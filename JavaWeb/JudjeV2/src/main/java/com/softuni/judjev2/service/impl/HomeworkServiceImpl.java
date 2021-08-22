package com.softuni.judjev2.service.impl;

import com.softuni.judjev2.repository.HomeworkRepository;
import com.softuni.judjev2.service.HomeworkService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class HomeworkServiceImpl implements HomeworkService {

    private final HomeworkRepository homeworkRepository;
    private final ModelMapper modelMapper;

    public HomeworkServiceImpl(HomeworkRepository homeworkRepository, ModelMapper modelMapper) {
        this.homeworkRepository = homeworkRepository;
        this.modelMapper = modelMapper;
    }
}
