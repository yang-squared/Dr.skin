from torch.utils.data import Dataset
from glob import glob 
from PIL import Image
from torchvision import transforms
import numpy as np 



class EffiDataset(Dataset):

    def __init__(self, data_list, labels, transform):
        super(EffiDataset, self).__init__()
        self.data_list = data_list
        self.labels = labels
        self.transform = transform
        self.item = {}

    def __len__(self):
        return len(self.data_list)

    def __getitem__(self, index):
        data_path = self.data_list[index]
        name = data_path.split('/')[-1].split('.')[0]
        
        img_pil = Image.open(data_path).convert('RGB')
        label_name = data_path.split('/')[-2]
        label_index = self.labels.index(label_name)
        label_index = np.array(int(label_index)).astype(int)
        
        if self.transform is not None:
            img_pil = self.transform(img_pil)

        item = {'name': name, 'img': img_pil, 'label': label_index, 'label_name': label_name}
        return item


