package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> getAllByAgeRestrictionEquals(AgeRestriction ageRestriction);

    List<String> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal first_price, BigDecimal second_price);

    List<String> findAllByReleaseDateIsNot(int year);

    List<String> findAllByTitleContaining(String title);

    List<String> findAllByReleaseDateIsBefore(String date);

    int countAllByTitleGreaterThan(Integer size);

    long findAllBooksCopiesByAuthorName(String author_firstName, String author_lastName);

    Book findBookByTitleEquals(String title);

    int countOfBooksWrittenByAuthorName(String first_name , String last_name);

    int increaseCopiesByDateWith(LocalDate localDate, int copies);

    int removeBooksByCopiesIsLessThan(Integer copies);
}
