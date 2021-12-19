package com.example.bootcampexam.model.binding;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public class CreateCandidateBindingModel {

    private String firstName;
    private String lastName;
    private String email;
    private String bio;
    private LocalDate birthDate;
    private List<String> skills;
    private String recruiterLastName;
    private String recruiterEmail;
    private String recruiterCountry;

    public CreateCandidateBindingModel() {
    }

    @NotBlank(message = "First name can not be empty!")
    @Size(min = 2, max = 20 , message = "First name length should be between 2 and 20 characters!")
    public String getFirstName() {
        return firstName;
    }

    public CreateCandidateBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @NotBlank(message = "Last name can not be empty!")
    @Size(min = 2, max = 20 , message = "Last name length should be between 2 and 20 characters!")
    public String getLastName() {
        return lastName;
    }

    public CreateCandidateBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Email(message = "Enter valid email address!")
    public String getEmail() {
        return email;
    }

    public CreateCandidateBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotBlank(message = "Bio can not be empty!")
    @Size(min = 10 , message = "Bio should be length min 10 characters!")
    public String getBio() {
        return bio;
    }

    public CreateCandidateBindingModel setBio(String bio) {
        this.bio = bio;
        return this;
    }

    @NotNull(message = "You must select date!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Date should be in past!")
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public CreateCandidateBindingModel setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    @NotNull
    @Size(min = 2 , message = "You must enter at least 2 skill!")
    public List<
            @NotBlank(message = "Skill can not be empty!")
            @Size(min = 2, message = "Size must be min 2 character!") String> getSkills() {
        return skills;
    }

    public CreateCandidateBindingModel setSkills(List<String> skills) {
        this.skills = skills;
        return this;
    }

    @NotBlank(message = "Last name can not be empty!")
    @Size(min = 2, max = 30 , message = "Last name length should be between 2 and 30 characters!")
    public String getRecruiterLastName() {
        return recruiterLastName;
    }

    public CreateCandidateBindingModel setRecruiterLastName(String recruiterLastName) {
        this.recruiterLastName = recruiterLastName;
        return this;
    }

    @Email(message = "Enter valid email address!")
    public String getRecruiterEmail() {
        return recruiterEmail;
    }

    public CreateCandidateBindingModel setRecruiterEmail(String recruiterEmail) {
        this.recruiterEmail = recruiterEmail;
        return this;
    }

    @NotBlank(message = "Country can not be empty!")
    @Size(min = 2, max = 30 , message = "Country length should be between 2 and 30 characters!")
    public String getRecruiterCountry() {
        return recruiterCountry;
    }

    public CreateCandidateBindingModel setRecruiterCountry(String recruiterCountry) {
        this.recruiterCountry = recruiterCountry;
        return this;
    }
}
