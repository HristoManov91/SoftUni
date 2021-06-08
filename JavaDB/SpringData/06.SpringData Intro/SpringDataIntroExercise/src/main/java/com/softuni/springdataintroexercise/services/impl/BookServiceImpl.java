package com.softuni.springdataintroexercise.services.impl;

import com.softuni.springdataintroexercise.constants.GlobalConstants;
import com.softuni.springdataintroexercise.repositories.BookRepository;
import com.softuni.springdataintroexercise.services.BookService;
import com.softuni.springdataintroexercise.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final FileUtil fileUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, FileUtil fileUtil) {
        this.bookRepository = bookRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() != 0){
            return;
        }

        String[] fileContent = this.fileUtil.readFileContent(GlobalConstants.BOOKS_FILE_PATH);


    }
}
