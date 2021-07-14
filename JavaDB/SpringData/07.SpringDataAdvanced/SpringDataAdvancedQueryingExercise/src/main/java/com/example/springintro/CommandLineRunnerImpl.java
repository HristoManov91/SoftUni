package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader bufferedReader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("Now select number of task you want to check from 1 to 14");
        String input = bufferedReader.readLine();
        while (!input.equals("End")) {
            switch (input) {
                case "1":
                    printAllBooksTitleWithAgeRestriction();
                    break;
                case "2":
                    printAllBooksTitleWithGoldenEditionTypeGold();
                    break;
                case "3":
                    printAllBooksWithPriceNotBetween5And40();
                    break;
                case "4":
                    printAllBooksTitleWhereReleaseDateNotIn();
                    break;
                case "5":
                    printAllBooksWithReleaseDateBefore();
                    break;
                case "6":
                    printAllAuthorsWithFirstNameEndsWith();
                    break;
                case "7":
                    printAllBooksTitleContainingString();
                    break;
                case "8":
                    printAllBooksTitleWithAuthorLastNameStartWith();
                    break;
                case "9":
                    printCountOfBooksWithTitleLengthMoreThan();
                    break;
                case "10":
                    printAllBooksCopiesByAuthorName();
                    break;
                case "11":
                    printBookInformationByTitle();
                    break;
                case "12":
                    increaseBooksCopiesAfterReleaseDate();
                    break;
                case "13":
                    printCountOfRemoveBooksByCopiesLessThan();
                    break;
                case "14":
                    printCountOfWrittenBooksByAuthorName();
                    break;
                default:
                    System.out.printf("This number %s of task is invalid,try again from 1 to 14%n", input);
                    break;
            }
            System.out.println("Write number of task you want to check or End for the end of the program");
            input = bufferedReader.readLine();
        }
        System.out.println("Thank you :)");
    }

    // ------------------------------------ 14 ------------------------------------

    private void printCountOfWrittenBooksByAuthorName() throws IOException {

        System.out.println("Enter the author's name and surname with a space between them:");
        String[] data = bufferedReader.readLine().split("\\s+");
        if (data.length != 2){
            System.out.println("Invalid name");
            return;
        }
        String firstName = data[0];
        String lastName = data[1];

        int count = bookService.countOfBooksWrittenByAuthorName(firstName , lastName);

        System.out.printf("%s %s has written %d books%n", firstName , lastName , count);
    }

    // ------------------------------------ 13 ------------------------------------

    private void printCountOfRemoveBooksByCopiesLessThan() throws IOException {
        System.out.println("Enter number of copies:");
        Integer copies = Integer.parseInt(bufferedReader.readLine());

        System.out.println(bookService.removeBooksByCopiesIsLessThan(copies));
    }

    // ------------------------------------ 12 ------------------------------------

    private void increaseBooksCopiesAfterReleaseDate() throws IOException {
        System.out.println("Enter date in format: (dd MMM yyyy)");
        String date = bufferedReader.readLine();
        LocalDate localDate = LocalDate.parse(date , DateTimeFormatter.ofPattern("dd MMM yyyy").withLocale(Locale.ENGLISH));
        System.out.println("Enter number of book copies each book should be increased:");
        int copies = Integer.parseInt(bufferedReader.readLine());

        System.out.println(bookService.increaseCopiesByDateWith(localDate, copies));
    }

    // ------------------------------------ 11 ------------------------------------

    private void printBookInformationByTitle() throws IOException {
        System.out.println("Enter book title:");
        String title = bufferedReader.readLine();

        Book book = this.bookService.findBookByTitleEquals(title);

        System.out.println(book.getTitle() + " "
                + book.getEditionType()+ " "
                + book.getAgeRestriction() + " "
                + book.getPrice());
    }

    // ------------------------------------ 10 ------------------------------------

    private void printAllBooksCopiesByAuthorName() throws IOException {
        System.out.println("Enter the author's name and surname with a space between them:");
        String[] data = bufferedReader.readLine().split("\\s+");
        if (data.length != 2){
            System.out.println("Invalid name");
            return;
        }
        String firstName = data[0];
        String lastName = data[1];

        long totalCopies = bookService.findAllBooksCopiesByAuthorName(firstName, lastName);

        System.out.printf("%s %s - %d%n", firstName , lastName , totalCopies);
    }

    // ------------------------------------ 9 ------------------------------------

    private void printCountOfBooksWithTitleLengthMoreThan() throws IOException {
        System.out.println("Enter title length:");
        int length = Integer.parseInt(bufferedReader.readLine());

        System.out.println(bookService.countAllByTitleGreaterThan(length));
    }

    // ------------------------------------ 8 ------------------------------------

    private void printAllBooksTitleWithAuthorLastNameStartWith() throws IOException {
        System.out.println("Enter param:");
        String param = bufferedReader.readLine();

        List<String> titles = authorService.findAllBooksTitleWithAuthorLastNameStartWith(param);

        System.out.println( titles.isEmpty()
                ? String.format("We do not have an author whose last name starts with this parameter \"%s\"", param)
                : String.join(System.lineSeparator(), titles));

//        if (titles.isEmpty()){
//            System.out.printf("We do not have an author whose last name starts with this parameter \"%s\"%n", param);
//            return;
//        }
//        titles.forEach(System.out::println);
    }

    // ------------------------------------ 7 ------------------------------------

    private void printAllBooksTitleContainingString() throws IOException {
        System.out.println("Enter param:");
        String param = bufferedReader.readLine();

        List<String> title = bookService.findAllByTitleContaining(param);
        if (title.isEmpty()){
            System.out.printf("We don't have book title with this param \"%s\"%n", param);
            return;
        }
        title.forEach(System.out::println);
    }

    // ------------------------------------ 6 ------------------------------------

    private void printAllAuthorsWithFirstNameEndsWith() throws IOException {
        System.out.println("Enter param:");
        String param = bufferedReader.readLine();
        ArrayList<Author> authors = new ArrayList<>(authorService.findAllByFirstNameEndsWith(param));
        if (authors.isEmpty()){
            System.out.printf("We don't have author with first name ends with %s%n", param);
            return;
        }
        authors.forEach(author -> System.out.printf("%s %s%n", author.getFirstName() , author.getLastName()));
    }

    // ------------------------------------ 5 ------------------------------------

    private void printAllBooksWithReleaseDateBefore() throws IOException {
        System.out.println("Enter date in format dd-MM-yyyy: (01-01-2020)");
        String date = bufferedReader.readLine();

        this.bookService.findAllByReleaseDateIsBefore(date).forEach(System.out::println);
    }

    // ------------------------------------ 4 ------------------------------------

    private void printAllBooksTitleWhereReleaseDateNotIn() throws IOException {
        System.out.println("Enter year: (only year)");
        int year = Integer.parseInt(bufferedReader.readLine());

        bookService.findAllByReleaseDateIsNot(year).forEach(System.out::println);
    }

    // ------------------------------------ 3 ------------------------------------

    private void printAllBooksWithPriceNotBetween5And40() {
        bookService.findAllByPriceLessThanOrPriceGreaterThan(new BigDecimal(5), new BigDecimal(40))
                .forEach(book -> System.out.printf("%s - $%.2f%n", book.getTitle() , book.getPrice()));
    }

    // ------------------------------------ 2 ------------------------------------

    private void printAllBooksTitleWithGoldenEditionTypeGold() {
        EditionType editionType = EditionType.valueOf("GOLD");

        bookService.findAllByEditionTypeAndCopiesLessThan(editionType , 5000).forEach(System.out::println);
    }

    // ------------------------------------ 1 ------------------------------------

    private void printAllBooksTitleWithAgeRestriction() throws IOException {
        System.out.println("Enter valid age restriction: (MINOR , TEEN , ADULT)");
        String input = bufferedReader.readLine().toUpperCase(Locale.ROOT);
        AgeRestriction ageRestriction = AgeRestriction.valueOf(input.toUpperCase(Locale.ROOT));
        if (ageRestriction.name().equals("TEEN")
                || ageRestriction.name().equals("MINOR")
                || ageRestriction.name().equals("ADULT")) {

            bookService.getAllByAgeRestrictionEquals(ageRestriction)
                    .stream()
                    .map(Book::getTitle)
                    .forEach(System.out::println);
        }
        System.out.printf("Invalid age restriction \"%s\"%n", input);
    }

    // ---------------------------------------------------------------------------

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
