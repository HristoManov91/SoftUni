package com.softuni.judjev2.service.impl;

import com.softuni.judjev2.model.entity.Exercise;
import com.softuni.judjev2.model.service.ExerciseServiceModel;
import com.softuni.judjev2.repository.ExerciseRepository;
import com.softuni.judjev2.service.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addExercise(ExerciseServiceModel exerciseServiceModel) {
        exerciseRepository.save(modelMapper.map(exerciseServiceModel , Exercise.class));
    }

    @Override
    public List<String> findAllNames() {
        return exerciseRepository.findAllNames();
    }
}
