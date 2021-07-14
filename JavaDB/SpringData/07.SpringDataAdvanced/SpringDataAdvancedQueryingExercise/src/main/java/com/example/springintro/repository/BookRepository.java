package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> getAllByAgeRestrictionEquals(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal first_price, BigDecimal second_price);

    List<Book> findAllByReleaseDateIsBeforeOrReleaseDateAfter(LocalDate lowerDate, LocalDate upperDate);

    List<Book> findAllByTitleContaining(String title);

    @Query ("SELECT COUNT(b) FROM Book b WHERE length(b.title) > :length ")
    int countOfBooksWithTitleLengthMoreThan(@Param(value = "length") int length);

    List<Book> findAllByReleaseDateIsBefore(LocalDate releaseDate);

    List<Book> findAllByAuthorFirstNameAndAuthorLastName(String author_firstName, String author_lastName);

    Book findBookByTitleEquals(String title);

    @Procedure //count_books_write_by_author_name
    Integer COUNT_BOOKS_WRITE_BY_AUTHOR_NAME(String first_name , String last_name);

    @Modifying
    @Query ("UPDATE Book b SET b.copies = b.copies + :copies WHERE b.releaseDate > :date")
    int updateCopiesByReleaseDateAfter(@Param(value = "copies") int copies,
                                       @Param(value = "date") LocalDate date);

    int removeBooksByCopiesIsLessThan(Integer copies);
}
