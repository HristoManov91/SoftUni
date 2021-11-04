package com.example.exam.model.service;

import com.example.exam.model.entity.enums.CategoryNameEnum;

public class ShipBattleServiceModel {

    private Long id;
    private String name;
    private Float health;
    private Long power;
    private CategoryNameEnum category;

    public ShipBattleServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ShipBattleServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipBattleServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public Float getHealth() {
        return health;
    }

    public ShipBattleServiceModel setHealth(Float health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipBattleServiceModel setPower(Long power) {
        this.power = power;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ShipBattleServiceModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
