package com.example.bootcampexam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "skills")
public class SkillEntity extends BaseEntity{

    private String name;

    public SkillEntity() {
    }

    @Column(nullable = false , length = 50)
    public String getName() {
        return name;
    }

    public SkillEntity setName(String name) {
        this.name = name;
        return this;
    }
}
