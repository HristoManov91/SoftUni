package com.example.jsonex.service.impl;

import com.example.jsonex.model.dto.CategoriesByProductCountDto;
import com.example.jsonex.model.dto.CategorySeedDto;
import com.example.jsonex.model.entity.Category;
import com.example.jsonex.model.entity.Product;
import com.example.jsonex.repository.CategoryRepository;
import com.example.jsonex.service.CategoryService;
import com.example.jsonex.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String PATH_TO_CATEGORIES_FILE = "src/main/resources/files/categories.json";
    private final CategoryRepository categoryRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() > 0){
            return;
        }
        String fileContent = Files.readString(Path.of(PATH_TO_CATEGORIES_FILE));

        CategorySeedDto[] categorySeedDtos = gson.fromJson(fileContent , CategorySeedDto[].class);

        Arrays.stream(categorySeedDtos)
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto , Category.class))
                .forEach(categoryRepository::save);
    }

    @Override
    public Set<Category> findRandomCategories() {
        Set<Category> categories = new HashSet<>();
        int catCount = ThreadLocalRandom.current().nextInt(1 , 3);
        long categoriesCount = categoryRepository.count();

        for (int i = 0; i < catCount; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1 , categoriesCount + 1);
            categories.add(categoryRepository.findById(randomId).orElse(null));
        }

        return categories;
    }

    @Override
    public List<CategoriesByProductCountDto> findAllOrderByProductsCount() {
        return categoryRepository.findAllOrderByProductsCount()
                .stream()
                .map(category -> {
                    CategoriesByProductCountDto map = modelMapper.map(category, CategoriesByProductCountDto.class);
                    map.setProductsCount(category.getProducts().size());
                    map.setTotalRevenue(totalRevenueOfCategory(category));
                    map.setAveragePrice(averagePriceProductsInCategory(category));
                    return map;
                })
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal totalRevenueOfCategory(Category category) {
        BigDecimal bigDecimal = category.getProducts()
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal::add)
                .get();

        return bigDecimal;
    }

    @Override
    public BigDecimal averagePriceProductsInCategory(Category category) {
        BigDecimal averagePrice = category.getProducts()
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(new BigDecimal(category.getProducts().size()) , 6 , RoundingMode.HALF_UP);

        return averagePrice;
    }
}
