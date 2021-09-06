package com.example.mobilelele.model.view;

import com.example.mobilelele.model.entity.Category;

public class ModelViewModel {

    private Long id;
    private String name;
    private Category category;
    private Integer startYear;
    private Integer endYear;
    private String picture;

    public String getName() {
        return name;
    }

    public ModelViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public ModelViewModel setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public ModelViewModel setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelViewModel setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public ModelViewModel setPicture(String picture) {
        this.picture = picture;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ModelViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "ModelViewModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", picture='" + picture + '\'' +
                '}';
    }
}
