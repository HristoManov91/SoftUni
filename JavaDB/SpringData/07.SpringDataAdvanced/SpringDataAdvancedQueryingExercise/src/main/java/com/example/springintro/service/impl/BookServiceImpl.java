package com.example.springintro.service.impl;

import com.example.springintro.model.entity.*;
import com.example.springintro.repository.BookRepository;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> getAllByAgeRestrictionEquals(AgeRestriction ageRestriction) {
        return this.bookRepository.getAllByAgeRestrictionEquals(ageRestriction);
    }

    @Override
    public List<String> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies) {
        return this.bookRepository.findAllByEditionTypeAndCopiesLessThan(editionType, copies)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal first_price, BigDecimal second_price) {
        return this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(first_price, second_price);
    }

    @Override
    public List<String> findAllByReleaseDateIsNot(int year) {
        LocalDate lowerBound = LocalDate.of(year , 1 , 1);
        LocalDate upperBound = LocalDate.of(year , 12 , 31);

        return this.bookRepository
                .findAllByReleaseDateIsBeforeOrReleaseDateAfter(lowerBound , upperBound)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllByTitleContaining(String title) {
        return this.bookRepository
                .findAllByTitleContaining(title)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllByReleaseDateIsBefore(String date) {
        LocalDate localDate = LocalDate.parse(date , DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return this.bookRepository
                .findAllByReleaseDateIsBefore(localDate)
                .stream()
                .map(book -> String.format("%s %s %.2f",
                        book.getTitle() , book.getEditionType().name() , book.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public long findAllBooksCopiesByAuthorName(String author_firstName, String author_lastName) {
        return this.bookRepository
                .findAllByAuthorFirstNameAndAuthorLastName(author_firstName, author_lastName)
                .stream()
                .map(Book::getCopies)
                .reduce(Integer::sum)
                .orElse(0);
    }

    @Override
    public Book findBookByTitleEquals(String title) {
        return this.bookRepository.findBookByTitleEquals(title);
    }

    @Override
    public int countOfBooksWrittenByAuthorName(String first_name, String last_name) {
        return this.bookRepository.COUNT_BOOKS_WRITE_BY_AUTHOR_NAME(first_name , last_name);
    }

    @Override
    @Transactional
    public int increaseCopiesByDateWith(LocalDate localDate, int copies) {
        int affectedRows = this.bookRepository.updateCopiesByReleaseDateAfter(copies , localDate);

        return affectedRows * copies;
    }

    @Override
    @Transactional
    public int removeBooksByCopiesIsLessThan(Integer copies) {
        return this.bookRepository.removeBooksByCopiesIsLessThan(copies);
    }

    @Override
    public int countAllByTitleGreaterThan(Integer size) {
        return this.bookRepository.countOfBooksWithTitleLengthMoreThan(size);
    }

    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }
}
