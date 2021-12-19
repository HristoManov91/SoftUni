package com.example.bootcampexam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.websocket.OnError;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "jobs")
public class JobEntity extends BaseEntity {

    private String title;
    private String description;
    private BigDecimal salary;
    private List<SkillEntity> skills;

    public JobEntity() {
    }

    @Column(nullable = false , length = 50)
    public String getTitle() {
        return title;
    }

    public JobEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    @Column(columnDefinition = "TEXT" , nullable = false)
    public String getDescription() {
        return description;
    }

    public JobEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(nullable = false)
    public BigDecimal getSalary() {
        return salary;
    }

    public JobEntity setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    @OneToMany
    public List<SkillEntity> getSkills() {
        return skills;
    }

    public JobEntity setSkills(List<SkillEntity> skills) {
        this.skills = skills;
        return this;
    }
}
