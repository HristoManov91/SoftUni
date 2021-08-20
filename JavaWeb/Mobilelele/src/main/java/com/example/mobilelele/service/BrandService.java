package com.example.mobilelele.service;

import com.example.mobilelele.model.entity.Brand;
import com.example.mobilelele.model.view.BrandViewModel;

import java.time.Instant;
import java.util.List;

public interface BrandService {

    void addBrand(String name , Instant createDate );

    Brand findById(Long id);

    List<BrandViewModel> getAllBrands();
}
