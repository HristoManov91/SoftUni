package com.example.advquerying.service.impl;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientRepository;
import com.example.advquerying.service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @Override
    public List<Ingredient> findAllByNameStartingWith(String param) {
        return this.ingredientRepository.findAllByNameStartingWith(param);
    }
}
