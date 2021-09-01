package com.ex.shopinglistapplication.repository;

import com.ex.shopinglistapplication.model.entity.Category;
import com.ex.shopinglistapplication.model.entity.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category , String> {

    Optional<Category> findByName(CategoryEnum name);
}
