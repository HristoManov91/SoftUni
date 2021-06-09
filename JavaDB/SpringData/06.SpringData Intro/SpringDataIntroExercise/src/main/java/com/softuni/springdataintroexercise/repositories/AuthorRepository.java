package com.softuni.springdataintroexercise.repositories;

import com.softuni.springdataintroexercise.entities.Author;
import com.softuni.springdataintroexercise.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author , Long> {

    @Query ("SELECT a FROM Author AS a ORDER BY a.books.size DESC")
    List<Author> findAuthorByCountOfBook();

    Author findAuthorByFirstNameEqualsAndLastNameEquals(String firstName , String lastName);
}
