package com.example.mobilelele.service.impl;

import com.example.mobilelele.model.entity.Brand;
import com.example.mobilelele.model.entity.Model;
import com.example.mobilelele.model.view.BrandViewModel;
import com.example.mobilelele.repository.BrandRepository;
import com.example.mobilelele.repository.ModelRepository;
import com.example.mobilelele.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper, ModelRepository modelRepository) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
    }

    @Override
    public void addBrand(String name, Instant createDate) {
        Brand brand = new Brand();
        brand.setName(name);
        brand.setCreated(createDate);
        brandRepository.save(brand);
    }

    @Override
    public Brand findById(Long id) {
        return brandRepository.findById(id).orElse(null);
    }

    @Override
    public List<BrandViewModel> getAllBrands() {
        List<BrandViewModel> brandViewModels = new ArrayList<>();

        List<Model> models = modelRepository.findAll();

        return brandViewModels;
    }


}
