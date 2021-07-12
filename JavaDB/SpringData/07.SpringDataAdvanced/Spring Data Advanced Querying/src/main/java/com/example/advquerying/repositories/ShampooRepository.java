package com.example.advquerying.repositories;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface ShampooRepository extends JpaRepository<Shampoo , Long> {

    List<Shampoo> findAllBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabel_IdOrderByPrice(Size size, Long label_id);

    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    Integer countAllByPriceLessThan(BigDecimal price);

    @Query ("SELECT s FROM Shampoo s JOIN s.ingredients i WHERE i.name IN :names")
    List<Shampoo> findAllByIngredientsNames(List<String> names);

//    @Query ("SELECT s FROM Shampoo s WHERE s.ingredients.size < :ingredientCount")
    @Query ("SELECT s FROM Shampoo s JOIN s.ingredients i GROUP BY s.id HAVING COUNT(i) < :ingredientCount")
    List<Shampoo> findAllByIngredientsCounts(Long ingredientCount);
}
