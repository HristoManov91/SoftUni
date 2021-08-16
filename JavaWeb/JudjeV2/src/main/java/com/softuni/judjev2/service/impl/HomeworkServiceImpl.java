package com.softuni.judjev2.service.impl;

import com.softuni.judjev2.repository.HomeworkRepository;
import com.softuni.judjev2.service.HomeworkService;
import org.springframework.stereotype.Service;

@Service
public class HomeworkServiceImpl implements HomeworkService {

    private final HomeworkRepository homeworkRepository;

    public HomeworkServiceImpl(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }
}
