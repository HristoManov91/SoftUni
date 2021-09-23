package com.example.mobilele.service.impl;

import com.example.mobilele.model.entity.BrandEntity;
import com.example.mobilele.repository.BrandRepository;
import com.example.mobilele.service.BrandService;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void saveBrand(BrandEntity brand) {
        brandRepository.save(brand);
    }

    @Override
    public BrandEntity findBrandById(long id) {
        return brandRepository.findById(id).orElse(null);
    }
}
