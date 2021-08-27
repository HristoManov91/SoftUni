package com.example.mobilelele.service.impl;

import com.example.mobilelele.model.entity.Category;
import com.example.mobilelele.model.entity.Model;
import com.example.mobilelele.repository.ModelRepository;
import com.example.mobilelele.service.BrandService;
import com.example.mobilelele.service.ModelService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Locale;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final BrandService brandService;

    public ModelServiceImpl(ModelRepository modelRepository, BrandService brandService) {
        this.modelRepository = modelRepository;
        this.brandService = brandService;
    }

    @Override
    public void addModel(String name, String category, String imageUrl, Integer startYear, Long brandId) {
        Model model = new Model();
        model.setName(name);
        model.setImageUrl(imageUrl);
        model.setStartYear(startYear);
        model.setBrand(brandService.findById(brandId));
        model.setCategory(Category.valueOf(category.toUpperCase(Locale.ROOT)));

        modelRepository.save(model);
    }

    @Override
    public Model findById(Long id) {
        return modelRepository.findById(id).orElseThrow();
    }
}
