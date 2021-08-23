package com.softuni.judjev2.service.impl;

import com.softuni.judjev2.model.entity.Homework;
import com.softuni.judjev2.repository.HomeworkRepository;
import com.softuni.judjev2.security.CurrentUser;
import com.softuni.judjev2.service.ExerciseService;
import com.softuni.judjev2.service.HomeworkService;
import com.softuni.judjev2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HomeworkServiceImpl implements HomeworkService {

    private final HomeworkRepository homeworkRepository;
    private final ExerciseService exerciseService;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public HomeworkServiceImpl(HomeworkRepository homeworkRepository, ExerciseService exerciseService, CurrentUser currentUser, UserService userService, ModelMapper modelMapper) {
        this.homeworkRepository = homeworkRepository;
        this.exerciseService = exerciseService;
        this.currentUser = currentUser;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addHomework(String exercise, String gitAddress) {
        Homework homework = new Homework();
        homework.setGitAddress(gitAddress)
                .setAddedOn(LocalDateTime.now())
                .setExercise(exerciseService.findByName(exercise))
                .setAuthor(userService.findByName(currentUser.getUsername()));

        homeworkRepository.save(homework);
    }
}
