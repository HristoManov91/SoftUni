package com.example.jsonex.service;

import com.example.jsonex.model.dto.CategoriesByProductCountDto;
import com.example.jsonex.model.entity.Category;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> findRandomCategories();

    List<CategoriesByProductCountDto> findAllOrderByProductsCount();

    BigDecimal totalRevenueOfCategory(Category category);

    BigDecimal averagePriceProductsInCategory(Category category);
}
