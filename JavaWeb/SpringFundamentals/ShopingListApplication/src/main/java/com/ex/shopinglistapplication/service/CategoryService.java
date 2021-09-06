package com.ex.shopinglistapplication.service;

import com.ex.shopinglistapplication.model.entity.Category;
import com.ex.shopinglistapplication.model.entity.CategoryEnum;

public interface CategoryService {

    void initCategories();

    Category findByName(CategoryEnum name);
}
