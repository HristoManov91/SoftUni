package com.softuni.springdataintroexercise.services.impl;

import com.softuni.springdataintroexercise.constants.GlobalConstants;
import com.softuni.springdataintroexercise.entities.Author;
import com.softuni.springdataintroexercise.repositories.AuthorRepository;
import com.softuni.springdataintroexercise.services.AuthorService;
import com.softuni.springdataintroexercise.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (authorRepository.count() != 0){
            return;
        }

        String[] fileContent = this.fileUtil.readFileContent(GlobalConstants.AUTHORS_FILE_PATH);

        Arrays.stream(fileContent).forEach(r -> {
            String firstName = r.split("\\s+")[0];
            String lastName = r.split("\\s+")[1];
            Author author = new Author(firstName , lastName);

            this.authorRepository.saveAndFlush(author);
        });
    }

    @Override
    public int getCountAuthors() {
        return (int) this.authorRepository.count();
    }

    @Override
    public Author findAuthorById(Long id) {
        return this.authorRepository.getById(id);
    }

    @Override
    public List<Author> findAllAuthorsByCountOfBooks() {
        return authorRepository.findAuthorByCountOfBook();
    }

    @Override
    public Author getAuthorByName() {
        return authorRepository.findAuthorByFirstNameEqualsAndLastNameEquals("George" , "Powell");
    }
}
