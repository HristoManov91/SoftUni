package com.softuni.judjev2.model.service;

public class HomeworkAddBindingModel {

    private Long id;
    private String exercise;
    private String gitAddress;

    public HomeworkAddBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public HomeworkAddBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getExercise() {
        return exercise;
    }

    public HomeworkAddBindingModel setExercise(String exercise) {
        this.exercise = exercise;
        return this;
    }

    public String getGitAddress() {
        return gitAddress;
    }

    public HomeworkAddBindingModel setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
        return this;
    }
}
