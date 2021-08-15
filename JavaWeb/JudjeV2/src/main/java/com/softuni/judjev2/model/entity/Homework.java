package com.softuni.judjev2.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "homework")
public class Homework extends BaseEntity{

    @Column(name = "added_on")
    private LocalDateTime addedOn;
    @Column(name = "git_address")
    private String gitAddress;
    @ManyToOne
    private User author;
    @ManyToOne
    private Exercise exercise;

    public Homework() {
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public Homework setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
        return this;
    }

    public String getGitAddress() {
        return gitAddress;
    }

    public Homework setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Homework setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public Homework setExercise(Exercise exercise) {
        this.exercise = exercise;
        return this;
    }
}
