package com.example.exam.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ships")
public class ShipEntity extends BaseEntity {

    private String name;
    private Float health;
    private Long power;
    private LocalDate created;
    private CategoryEntity category;
    private UserEntity userEntity;

    public ShipEntity() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public ShipEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Column(nullable = false)
    public Float getHealth() {
        return health;
    }

    public ShipEntity setHealth(Float health) {
        this.health = health;
        return this;
    }

    @Column(nullable = false)
    public Long getPower() {
        return power;
    }

    public ShipEntity setPower(Long power) {
        this.power = power;
        return this;
    }

    @Column(nullable = false)
    public LocalDate getCreated() {
        return created;
    }

    public ShipEntity setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    @ManyToOne
    public CategoryEntity getCategory() {
        return category;
    }

    public ShipEntity setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public ShipEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }
}
