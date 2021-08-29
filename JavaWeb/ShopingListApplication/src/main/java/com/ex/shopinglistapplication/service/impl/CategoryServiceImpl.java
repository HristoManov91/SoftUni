package com.ex.shopinglistapplication.service.impl;

import com.ex.shopinglistapplication.model.entity.Category;
import com.ex.shopinglistapplication.model.entity.CategoryEnum;
import com.ex.shopinglistapplication.repository.CategoryRepository;
import com.ex.shopinglistapplication.service.CategoryService;
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
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryEnum.values()).forEach(categoryEnum -> {
                Category category =
                        new Category(categoryEnum, "Description for " + categoryEnum.name());

                categoryRepository.save(category);
            });
        }
    }
}
