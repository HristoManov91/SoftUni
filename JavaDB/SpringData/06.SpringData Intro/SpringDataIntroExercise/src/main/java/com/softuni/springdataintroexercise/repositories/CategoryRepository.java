package com.softuni.springdataintroexercise.repositories;

import com.softuni.springdataintroexercise.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category , Long> {
}
