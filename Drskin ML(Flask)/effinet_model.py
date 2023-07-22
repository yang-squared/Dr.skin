import torch
import torchvision
from torchvision import datasets
from torchvision import transforms
import torch.nn as nn
import torch.nn.functional as F
from torch.autograd import Variable
from torchvision.utils import save_image
import os
import time
import datetime
import copy
import numpy as np
from efficientnet_pytorch import EfficientNet


class Effinet(nn.Module):
    def __init__(self, pretrained='efficientnet-b4', image_size=224, num_classes=1, dropout=0.2):
        super(Effinet, self).__init__()

        self.image_size = image_size
        self.num_classes = num_classes
        self.dropout = dropout

        # EfficientNet Pretrained model
        self.model = EfficientNet.from_pretrained(pretrained)

        # fc
        self.fc_layer = nn.Sequential(
            nn.Dropout(p=self.dropout),
            nn.Linear(1000, self.num_classes)
        )

    def forward(self, data):
        features = self.model(data)
        in_dim = features.shape[1]

        # classifier
        output = self.fc_layer(features)
        return output



