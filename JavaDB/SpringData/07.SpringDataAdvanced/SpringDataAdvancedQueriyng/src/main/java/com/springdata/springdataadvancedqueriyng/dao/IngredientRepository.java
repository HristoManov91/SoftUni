package com.springdata.springdataadvancedqueriyng.dao;

import com.springdata.springdataadvancedqueriyng.entity.Ingredient;
import com.springdata.springdataadvancedqueriyng.entity.Shampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
