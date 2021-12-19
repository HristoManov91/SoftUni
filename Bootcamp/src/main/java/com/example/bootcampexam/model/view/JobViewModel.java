package com.example.bootcampexam.model.view;

import com.example.bootcampexam.model.entity.SkillEntity;

import java.math.BigDecimal;
import java.util.List;

public class JobViewModel {

    private String title;
    private String description;
    private BigDecimal salary;
    private List<SkillViewModel> skills;

    public JobViewModel() {
    }

    public String getTitle() {
        return title;
    }

    public JobViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public JobViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public JobViewModel setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public List<SkillViewModel> getSkills() {
        return skills;
    }

    public JobViewModel setSkills(List<SkillViewModel> skills) {
        this.skills = skills;
        return this;
    }
}
