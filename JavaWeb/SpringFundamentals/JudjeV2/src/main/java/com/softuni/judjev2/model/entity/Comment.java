package com.softuni.judjev2.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{

    @Column(name = "score" , nullable = false)
    private Integer score;
    @Column(name = "text_content" , columnDefinition = "TEXT")
    private String textContent;
    @ManyToOne
    private User author;
    @ManyToOne
    private Homework homework;

    public Comment() {
    }

    public Integer getScore() {
        return score;
    }

    public Comment setScore(Integer score) {
        this.score = score;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public Comment setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Comment setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Homework getHomework() {
        return homework;
    }

    public Comment setHomework(Homework homework) {
        this.homework = homework;
        return this;
    }
}
