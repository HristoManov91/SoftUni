package com.example.springintro.service;

import com.example.springintro.model.entity.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<Author> findAllByFirstNameEndsWith(String param);

    List<String> findAllBooksTitleWithAuthorLastNameStartWith(String param);
}
