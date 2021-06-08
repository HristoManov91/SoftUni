package com.softuni.springdataintroexercise.repositories;

import com.softuni.springdataintroexercise.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author , Long> {
}
