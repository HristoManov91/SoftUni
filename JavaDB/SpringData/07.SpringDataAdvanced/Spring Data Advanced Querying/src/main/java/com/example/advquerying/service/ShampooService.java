package com.example.advquerying.service;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface ShampooService {

    List<Shampoo> findAllBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabel_IdOrderByPrice(Size size, Long label_id);

    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    Integer countAllByPriceLessThan(BigDecimal price);

    List<Shampoo> findAllByIngredientsNames(List<String> names);

    List<Shampoo> findAllByIngredientsCounts(Long ingredientCount);
}
