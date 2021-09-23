package com.example.mobilele.service;

import com.example.mobilele.model.entity.BrandEntity;

public interface BrandService {
    void saveBrand(BrandEntity brand);

    BrandEntity findBrandById(long id);
}
