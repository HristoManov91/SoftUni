package com.example.mobilele.service;

import com.example.mobilele.model.entity.ModelEntity;

public interface ModelService {
    void saveModel(ModelEntity model);

    ModelEntity findByName(String name);
}
