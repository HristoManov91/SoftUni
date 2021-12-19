package com.example.bootcampexam.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "candidates")
public class CandidateEntity extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String bio;
    private LocalDate birthDate;
    private List<SkillEntity> skills;
    private RecruiterEntity recruiterEntity;

    public CandidateEntity() {
    }

    @Column(nullable = false , length = 20)
    public String getFirstName() {
        return firstName;
    }

    public CandidateEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(nullable = false , length = 20)
    public String getLastName() {
        return lastName;
    }

    public CandidateEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column(nullable = false , unique = true)
    public String getEmail() {
        return email;
    }

    public CandidateEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(columnDefinition = "TEXT" , nullable = false)
    public String getBio() {
        return bio;
    }

    public CandidateEntity setBio(String bio) {
        this.bio = bio;
        return this;
    }

    @Column(nullable = false)
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public CandidateEntity setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    @OneToMany
    public List<SkillEntity> getSkills() {
        return skills;
    }

    public CandidateEntity setSkills(List<SkillEntity> skills) {
        this.skills = skills;
        return this;
    }

    @ManyToOne
    public RecruiterEntity getRecruiterEntity() {
        return recruiterEntity;
    }

    public CandidateEntity setRecruiterEntity(RecruiterEntity recruiterEntity) {
        this.recruiterEntity = recruiterEntity;
        return this;
    }
}
