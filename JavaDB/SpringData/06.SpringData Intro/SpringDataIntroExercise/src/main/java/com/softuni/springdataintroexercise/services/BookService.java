package com.softuni.springdataintroexercise.services;

import com.softuni.springdataintroexercise.entities.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> getAllBooksAfter2000Year();

    List<Book> getAllBooksFromAuthorGeorgePowell();
}
