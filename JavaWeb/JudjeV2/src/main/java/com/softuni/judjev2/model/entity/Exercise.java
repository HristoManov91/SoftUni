package com.softuni.judjev2.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "exercises")
public class Exercise extends BaseEntity{

    @Column(name = "name" , nullable = false)
    private String name;
    @Column(name = "started_on")
    private LocalDateTime startedOn;
    @Column(name = "due_date")
    private LocalDateTime dueDate;

    public Exercise() {
    }

    public String getName() {
        return name;
    }

    public Exercise setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getStartedOn() {
        return startedOn;
    }

    public Exercise setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
        return this;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public Exercise setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
        return this;
    }
}
