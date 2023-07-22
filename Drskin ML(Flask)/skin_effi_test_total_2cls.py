

import os
import time
import datetime
import copy
import numpy as np
from PIL import Image
import cv2
import easydict
import shutil



import torch
from torchvision import transforms
import torch.nn as nn
from torch.autograd import Variable
from torch.utils.data import Dataset, DataLoader
from sklearn.metrics import f1_score, confusion_matrix, classification_report



from effinet_model import Effinet
# from effinet_utils import EffiDataset




# ==========================================================================================
# Configuration


# GPU Setting
os.environ['CUDA_DEVICE_ORDER'] = 'PCI_BUS_ID'
os.environ['CUDA_VISIBLE_DEVICES'] = '3'
device = torch.device('cuda' if torch.cuda.is_available() else 'cpu')



data_dir = '../dataset/2classes/'
LABELS = os.listdir(data_dir + 'train/')
LABELS.sort()




args = easydict.EasyDict({
        'image_size': 224,
        'model_dir': './models/',
        'model_name': 'skincancer_classifier_2cls.pt'
})





# ==========================================================================================
# Model, Loss, and Optimizer

model = Effinet(pretrained='efficientnet-b4', image_size=224, num_classes=len(LABELS), dropout=0.3)
try:
    if torch.cuda.is_available():
        checkpoint = torch.load(args.model_dir + args.model_name)
    else:
        checkpoint = torch.load(args.model_dir + args.model_name, map_location=torch.device('cpu'))
    model.load_state_dict(checkpoint)
    print('Total params: %.2fM' % (sum(p.numel() for p in model.parameters()) / 1000000.0))
    #
except Exception as ex:
    print(str(ex))



model = model.to(device)
model = model.eval()




# ==========================================================================================
# Test

# transform
pixel_mean, pixel_std = 0.66133188,  0.21229856     # for Grayscale
preprocess = transforms.Compose([
   transforms.Resize((224, 224)),
   transforms.ToTensor(),
   transforms.Normalize([pixel_mean]*3, [pixel_std]*3)
])





test_dir = '../dataset/2classes/valid/'
# test_dir = '../dataset/2classes/train/'



preds = []
labels = []
results = []
with torch.no_grad():
    for dirname, subdir, files in os.walk(test_dir):
        # ------------------------------------------------------------------
        for img_file in files:
            if img_file.split('.')[-1].lower() not in ['jpg', 'png', 'jpeg']:
                continue
            # --------------------------------------------------------------
            img_pil = Image.open(dirname + '/' + img_file).convert('RGB')
            img_tensor = preprocess(img_pil)
            img_tensor = Variable(img_tensor.unsqueeze(0))
            img_tensor = img_tensor.to(device)
            #
            # Forward
            pred = model(img_tensor)
            sigmoid = nn.Sigmoid()
            output = sigmoid(pred)
            prob, pred_index = torch.max(output.data, 1)
            prob = np.array(prob.cpu())[0]
            pred_index = np.array(pred_index.cpu())[0]
            preds.append(pred_index)
            pred_name = LABELS[pred_index]
            #
            label_name = dirname.split('/')[-1]
            results.append([dirname + '/' + img_file, label_name, pred_name, np.round(prob, 3)])
            # -----------------------------------------------------------------------------------
            if True:
                label_name = dirname.split('/')[-1]
                try:
                    label_index = LABELS.index(label_name)
                    labels.append(label_index)
                    if pred_index != label_index:
                        print(dirname, img_file, ',label=', label_index, ', pred=', pred_index)
                        save_dir = dirname.replace('dataset', 'results') + '/{}/'.format(pred_name)
                        os.makedirs(save_dir, exist_ok=True)
                        #
                        src = dirname + '/' + img_file
                        dst = save_dir + '/' + img_file
                        temp = shutil.copy(src, dst)
                except Exception as ex:
                    print(str(ex))
            else:
                save_dir = dirname.replace('dataset', 'results') + '/{}/'.format(pred_name)
                # os.makedirs(save_dir, exist_ok=True)
                #
                src = dirname + '/' + img_file
                dst = save_dir + '/{}_{}'.format('%.3f' % prob, img_file)
                # shutil.copy(src, dst)



if True:
    import pandas as pd
    pd_results = pd.DataFrame(results)
    pd_results.columns = ['filepath', 'label', 'predict', 'prob']
    pd_results.to_excel('../results/2classes/valid.xlsx', index=False)
    # pd_results.to_excel('../results/2classes/train.xlsx', index=False)



if True:
    if len(labels) == len(preds):
        preds = np.array(preds)
        labels = np.array(labels)
        conf_matrix = confusion_matrix(labels, preds)
        print('Test Set Confusion_matrix: \n\n', conf_matrix)
        print('Test Set Accuracy:', 1.0 * np.trace(conf_matrix) / np.sum(conf_matrix))
        #
        import pandas as pd
        conf_mat = confusion_matrix(labels, preds)
        pd_conf_mat = pd.DataFrame(conf_mat)
        pd_conf_mat.columns = LABELS
        #
        os.makedirs('../results/', exist_ok=True)
        pd_conf_mat.to_excel('../results/2classes/conf_matrix_valid.xlsx', index=False)
        # pd_conf_mat.to_excel('../results/2classes/conf_matrix_train.xlsx', index=False)





# nohup python skin_effi_test_total.py   output.log 2&1 &


