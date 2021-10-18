package com.example.exam.service.impl;

import com.example.exam.model.entity.CategoryEntity;
import com.example.exam.model.entity.enums.CategoryNameEnum;
import com.example.exam.repository.CategoryRepository;
import com.example.exam.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0){
            Arrays.stream(CategoryNameEnum.values())
                    .map(c -> new CategoryEntity().setName(c))
                    .forEach(categoryRepository::save);
        }
    }

    @Override
    public CategoryEntity findByName(CategoryNameEnum categoryName) {
        return categoryRepository.findByName(categoryName).orElse(null);
    }
}
