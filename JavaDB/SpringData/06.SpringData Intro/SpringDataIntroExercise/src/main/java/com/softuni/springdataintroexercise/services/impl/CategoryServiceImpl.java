package com.softuni.springdataintroexercise.services.impl;

import com.softuni.springdataintroexercise.constants.GlobalConstants;
import com.softuni.springdataintroexercise.entities.Category;
import com.softuni.springdataintroexercise.repositories.CategoryRepository;
import com.softuni.springdataintroexercise.services.CategoryService;
import com.softuni.springdataintroexercise.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

import static com.softuni.springdataintroexercise.constants.GlobalConstants.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() != 0){
            return;
        }

        String[] fileContent = this.fileUtil.readFileContent(CATEGORIES_FILE_PATH);

        Arrays.stream(fileContent).forEach(r -> {
            Category category = new Category(r);

            this.categoryRepository.saveAndFlush(category);
        });
    }
}
