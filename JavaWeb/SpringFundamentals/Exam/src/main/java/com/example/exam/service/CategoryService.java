package com.example.exam.service;

import com.example.exam.model.entity.CategoryEntity;
import com.example.exam.model.entity.enums.CategoryNameEnum;

public interface CategoryService {

    void initCategories();

    CategoryEntity findByName(CategoryNameEnum categoryName);
}
