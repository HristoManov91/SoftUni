package com.softuni.judjev2.service;

import com.softuni.judjev2.model.entity.Exercise;
import com.softuni.judjev2.model.service.ExerciseServiceModel;

import java.util.List;

public interface ExerciseService {
    void addExercise(ExerciseServiceModel exerciseServiceModel);

    List<String> findAllNames();

    boolean check(String exercise);

    Exercise findByName(String exercise);
}
