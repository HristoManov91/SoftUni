package com.ex.shopinglistapplication.repository;

import com.ex.shopinglistapplication.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category , String> {
}
