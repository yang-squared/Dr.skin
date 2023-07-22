

import os
import time
import datetime
import copy
import numpy as np
import pandas as pd
import easydict


import torch
from torchvision import transforms
import torch.nn as nn
from torch.autograd import Variable
from torch.utils.data import Dataset, DataLoader



from effinet_model import Effinet
from effinet_utils import EffiDataset




# ==========================================================================================
# Configuration

# GPU Setting : Multi GPU 인 경우, GPU선택시 (설정 안하면 전체 사용)
os.environ['CUDA_DEVICE_ORDER'] = 'PCI_BUS_ID'
os.environ['CUDA_VISIBLE_DEVICES'] = '3'            # 0번 GPU 사용 ('0,1': 0번, 1번 GPU사용)



device = torch.device('cuda' if torch.cuda.is_available() else 'cpu')       # GPU device, 없으면 CPU device 선택



data_dir = '../dataset/2classes/'
LABELS = os.listdir(data_dir + 'train/')
LABELS.sort()


args = easydict.EasyDict({
        'image_size': 224,                  # 224 x 224
        'data_dir': data_dir,    # Dataset 기본 폴더 (이 밑으로 train / valid 폴더 구성)
        'model_dir': './models/',          # model 저장 폴더
        'model_name': 'skincancer_classifier_2cls.pt',      # model 이름
        #
        # Training Settings
        'epochs': 1000,
        'batch_size': 10,
        'lr': 1e-4,                         # learning_rate
        'wd': 1e-4,                         # optimizer에 적용하는 weight_decay: overfitting 방지 역할
        'dropout': 0.3,                     # dropout: overfitting 방지 기법 중 하나
})
os.makedirs(args.model_dir, exist_ok=True)  # model_dir 생성하기






# ==========================================================================================
# Dataset
train_list = []
for dirname, subdirs, files in os.walk(args.data_dir + 'train/'):
    for img_file in files:
        if img_file.split('.')[-1].lower() not in ['jpg', 'png', 'gif', 'jpeg']:        # image 파일이 아니면 무시
            continue
        train_list.append(dirname + '/' + img_file)



valid_list = []
for dirname, subdirs, files in os.walk(args.data_dir + 'valid/'):
    for img_file in files:
        if img_file.split('.')[-1].lower() not in ['jpg', 'png', 'gif', 'jpeg']:
            continue
        valid_list.append(dirname + '/' + img_file)




print('Trainset num: {}, Validationset num: {}'.format(len(train_list), len(valid_list)))




# ==========================================================================================
# Dataloader

pixel_mean, pixel_std = 0.66133188,  0.21229856
data_transform_train = transforms.Compose(
    [
        transforms.Resize((224, 224)),                 # Resize to 224 x 224
        transforms.ColorJitter(brightness=0.3, contrast=0.3, saturation=0.3, hue=0.3),
        transforms.RandomAffine(degrees=10, translate=(0.1, 0.1), scale=(0.9, 1.1)),
        transforms.RandomRotation(360, expand=False),
        transforms.ToTensor(),
        transforms.Normalize([pixel_mean]*3, [pixel_std]*3)
    ]
)

data_transform_valid = transforms.Compose(
    [
        transforms.Resize((224, 224)),
        transforms.ToTensor(),
        transforms.Normalize([pixel_mean]*3, [pixel_std]*3)
    ]
)



train_data = EffiDataset(train_list, LABELS, data_transform_train)
train_loader = DataLoader(train_data, batch_size=args.batch_size, shuffle=True, num_workers=2, drop_last=True)


valid_data = EffiDataset(valid_list, LABELS, data_transform_valid)
valid_loader = DataLoader(valid_data, batch_size=args.batch_size, shuffle=False, num_workers=2)




# ==========================================================================================
# Model, Loss, and Optimizer

# Effinet 모델 기본 틀 구성
model = Effinet(pretrained='efficientnet-b4', image_size=224, num_classes=len(LABELS), dropout=args.dropout)
try:
    # 사전 저장된 모델 불러오기
    if torch.cuda.is_available():
        checkpoint = torch.load(args.model_dir + args.model_name)
    else:
        checkpoint = torch.load(args.model_dir + args.model_name, map_location=torch.device('cpu'))
    model.load_state_dict(checkpoint)
    #
except Exception as ex:
    print(str(ex))



# Optimizer & Loss
optim = torch.optim.Adam(model.parameters(), args.lr, weight_decay=args.wd)     # Adam optimizer 사용시
criterion = nn.CrossEntropyLoss()
model = model.to(device)




# ==========================================================================================
# Train
min_loss = 100          # loss 초기값
for epoch in range(args.epochs):
    print('\n===> Epoch [%d/%d]' % (epoch+1, args.epochs))
    #
    running_loss = 0.0
    n_samples = 0
    correct = 0
    temp = model.train()
    for i, data in enumerate(train_loader, 0):
        name, img_pil, label, label_name = data['name'], data['img'], data['label'], data['label_name']
        img_tensor = Variable(img_pil).to(device)
        labels = Variable(label).to(device)
        #
        # Forward
        output = model(img_tensor)
        output = nn.Sigmoid()(output)       # 0~1 확률값으로 변환
        #
        # Loss
        if isinstance(output, tuple):
            output = output[0]
        _, preds = torch.max(output.data, 1)
        loss = criterion(output, labels)
        #
        # Backpropagation
        optim.zero_grad()
        loss.backward()
        optim.step()
        #
        # Print statistics
        n_batch = int(img_tensor.size()[0])
        n_samples += n_batch
        running_loss += loss.data
        correct += torch.sum(preds == labels.data)
        #
        # Print every N epochs
        if i % 10 == 9:
            print('     - Iteration [%3d / %3d]   Classification_Loss: %.3f   Accuracy: %d%%'% (
                i + 1, len(train_loader), running_loss / n_samples, 100 * correct / n_samples))
    #
    train_loss = running_loss.item() / n_samples
    train_acc = 100 * correct.item() / n_samples
    #
    # ------------------------------------------------------------------------------------
    # Validation
    temp = model.eval() # evaluation용 (weight변화 없음)
    correct = 0
    n_samples = 0
    val_loss = 0
    #
    with torch.no_grad():
        for i, data in enumerate(valid_loader, 0):
            name, img_pil, label, label_name = data['name'], data['img'], data['label'], data['label_name']
            img_tensor = Variable(img_pil).to(device)
            labels = Variable(label).to(device)
            #
            # Forward
            output = model(img_tensor)
            output = nn.Sigmoid()(output)
            _, preds = torch.max(output.data, 1)
            #
            n_batch = int(img_tensor.size()[0])
            n_samples += n_batch
            val_loss += criterion(output, labels).item()
            #
            # Accuracy
            correct += torch.sum(preds == labels.data)
    #
    val_loss = val_loss / n_samples
    val_acc = 100 * correct.item() / n_samples
    #
    print('===========================================================================')
    print('     - Validation: Classification loss %.4f   Accuracy: %d%% \n' % (val_loss, 100 * correct/n_samples))
    #
    # val_loss값이 기존 min_loss 값을 갱신했을 때 모델 저장
    if val_loss <= min_loss:
        min_loss = val_loss
        torch.save(model.state_dict(), os.path.join(args.model_dir, args.model_name))





# nohup python skin_effi_train_2cls.py   output.log 2&1 &


