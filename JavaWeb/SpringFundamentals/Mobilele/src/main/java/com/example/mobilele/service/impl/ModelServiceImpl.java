package com.example.mobilele.service.impl;

import com.example.mobilele.model.entity.ModelEntity;
import com.example.mobilele.repository.ModelRepository;
import com.example.mobilele.service.ModelService;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public void saveModel(ModelEntity model) {
        modelRepository.save(model);
    }

    @Override
    public ModelEntity findByName(String name) {
        return modelRepository.findByName(name).orElse(null);
    }
}
