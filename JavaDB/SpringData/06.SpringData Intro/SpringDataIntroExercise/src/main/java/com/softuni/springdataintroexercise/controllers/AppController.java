package com.softuni.springdataintroexercise.controllers;

import com.softuni.springdataintroexercise.entities.Author;
import com.softuni.springdataintroexercise.entities.Book;
import com.softuni.springdataintroexercise.services.AuthorService;
import com.softuni.springdataintroexercise.services.BookService;
import com.softuni.springdataintroexercise.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;


@Controller
public class AppController implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write number of task you want to see or STOP to over:");
        String input = scanner.nextLine();
        while (!input.equals("STOP")) {
            switch (input) {
                case "1":
                    List<Book> books = this.bookService.getAllBooksAfter2000Year();
                    books.forEach(b -> System.out.println(b.getTitle()));
                    break;
                case "2":
                    break;
                case "3":
                    this.authorService.findAllAuthorsByCountOfBooks().forEach(a ->
                            System.out.printf("%s %s %d%n", a.getFirstName() , a.getLastName() , a.getBooks().size()));
                    break;
                case "4":
                    this.bookService.getAllBooksFromAuthorGeorgePowell().forEach(b -> {
                        System.out.printf("%s %s %d%n", b.getTitle() , b.getReleaseDate() , b.getCopies());
                    });
                    break;
                default:
                    System.out.printf("The number of task %s is invalid%n", input);
                    break;
            }
            System.out.println("Write number of task you want to see or STOP to over:");
            input = scanner.nextLine();
        }
    }
}
