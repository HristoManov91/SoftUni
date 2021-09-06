package com.ex.shopinglistapplication.repository;

import com.ex.shopinglistapplication.model.entity.Category;
import com.ex.shopinglistapplication.model.entity.CategoryEnum;
import com.ex.shopinglistapplication.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product , String> {

    @Query("SELECT SUM(p.price) FROM Product p")
    BigDecimal findTotalProductSum();

    List<Product> findAllByCategory_NameOrderByNeededBefore(CategoryEnum categoryName);
}
