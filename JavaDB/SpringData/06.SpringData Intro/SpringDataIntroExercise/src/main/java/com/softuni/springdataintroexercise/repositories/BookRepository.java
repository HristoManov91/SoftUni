package com.softuni.springdataintroexercise.repositories;

import com.softuni.springdataintroexercise.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book , Long> {
}
