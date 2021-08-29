package com.ex.shopinglistapplication.repository;

import com.ex.shopinglistapplication.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product , String> {
}
