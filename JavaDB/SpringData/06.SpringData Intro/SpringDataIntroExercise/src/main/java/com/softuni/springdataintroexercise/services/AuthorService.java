package com.softuni.springdataintroexercise.services;

import com.softuni.springdataintroexercise.entities.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;
    int getCountAuthors();
    Author findAuthorById(Long id);
    List<Author> findAllAuthorsByCountOfBooks();
    Author getAuthorByName();
}
