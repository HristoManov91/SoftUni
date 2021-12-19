package com.example.bootcampexam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "recruiters")
public class RecruiterEntity extends BaseEntity{

    private String lastName;
    private String email;
    private String country;
    private Integer level;
    private List<CandidateEntity> candidates;

    public RecruiterEntity() {
    }

    @Column(nullable = false , length = 30 , unique = true)
    public String getLastName() {
        return lastName;
    }

    public RecruiterEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column(nullable = false , length = 50 , unique = true)
    public String getEmail() {
        return email;
    }

    public RecruiterEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(nullable = false , length = 30)
    public String getCountry() {
        return country;
    }

    public RecruiterEntity setCountry(String country) {
        this.country = country;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public RecruiterEntity setLevel(Integer level) {
        this.level = level;
        return this;
    }

    @OneToMany
    public List<CandidateEntity> getCandidates() {
        return candidates;
    }

    public RecruiterEntity setCandidates(List<CandidateEntity> candidates) {
        this.candidates = candidates;
        return this;
    }
}
