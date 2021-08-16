package com.softuni.judjev2.service.impl;

import com.softuni.judjev2.repository.ExerciseRepository;
import com.softuni.judjev2.service.ExerciseService;
import org.springframework.stereotype.Service;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }
}
