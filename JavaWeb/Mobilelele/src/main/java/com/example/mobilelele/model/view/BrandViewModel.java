package com.example.mobilelele.model.view;

import java.util.List;

public class BrandViewModel {

    private Long id;

    private String name;

    private List<ModelViewModel> models;

    public List<ModelViewModel> getModels() {
        return models;
    }

    public BrandViewModel setModels(List<ModelViewModel> models) {
        this.models = models;
        return this;
    }

    public String getName() {
        return name;
    }

    public BrandViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public BrandViewModel setId(Long id) {
        this.id = id;
        return this;
    }
}
