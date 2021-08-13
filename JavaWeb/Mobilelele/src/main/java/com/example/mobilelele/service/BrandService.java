package com.example.mobilelele.service;

import com.example.mobilelele.model.entity.Brand;

import java.time.Instant;

public interface BrandService {

    void addBrand(String name , Instant createDate );

    Brand findById(Long id);
}
