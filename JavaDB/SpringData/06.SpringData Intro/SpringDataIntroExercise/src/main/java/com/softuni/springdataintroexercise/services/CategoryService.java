package com.softuni.springdataintroexercise.services;

import com.softuni.springdataintroexercise.entities.Category;

import java.io.IOException;

public interface CategoryService {
    void seedCategories() throws IOException;

    Category getCategoryById(Long id);
}
