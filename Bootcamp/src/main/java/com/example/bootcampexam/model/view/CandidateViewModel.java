package com.example.bootcampexam.model.view;

import java.time.LocalDate;
import java.util.List;

public class CandidateViewModel {

    private String firstName;
    private String lastName;
    private String email;
    private String bio;
    private LocalDate birthDate;
    private List<SkillViewModel> skills;
    private RecruiterViewModel recruiter;

    public CandidateViewModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public CandidateViewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CandidateViewModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CandidateViewModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getBio() {
        return bio;
    }

    public CandidateViewModel setBio(String bio) {
        this.bio = bio;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public CandidateViewModel setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public List<SkillViewModel> getSkills() {
        return skills;
    }

    public CandidateViewModel setSkills(List<SkillViewModel> skills) {
        this.skills = skills;
        return this;
    }

    public RecruiterViewModel getRecruiter() {
        return recruiter;
    }

    public CandidateViewModel setRecruiter(RecruiterViewModel recruiter) {
        this.recruiter = recruiter;
        return this;
    }
}
