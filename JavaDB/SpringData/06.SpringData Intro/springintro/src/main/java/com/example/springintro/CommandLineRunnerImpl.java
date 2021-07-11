package com.example.springintro;

import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello,first check a user and password in application.properties file!");
        System.out.println("Enter OK if you want to create a database and load with data");
        seedDatabase();

        System.out.println("Enter a number query you want to check from 1 to 4");
        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            switch (input) {
                case "1" -> printAllBooksAfter2000(2000);
                case "2" -> printAllAuthorsNamesWithBooksReleaseDateBefore1990(1990);
                case "3" -> printAllAuthorsAndNumberOfTheirBooks();
                case "4" -> printAllBooksByAuthorNameOrderByReleaseDate("George", "Powell");
                default -> System.out.println("Invalid number of task");
            }
            System.out.println("Enter a number query you want to check from 1 to 4 or Stop");
            input = scanner.nextLine();
        }
        System.out.println("Thank you :)");
    }

    private void seedDatabase() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }

    private void printAllBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService.getAllAuthorsOrderByCountOfTheirBooks().forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksReleaseDateBefore1990(int year) {
        bookService.findAllBooksAuthorsWithReleaseDateBeforeYear(year).forEach(System.out::println);
    }

    private void printAllBooksAfter2000(int year) {
        bookService.findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }
}
