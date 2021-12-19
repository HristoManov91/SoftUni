package com.example.bootcampexam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    private String username;
    private String password;
    private String email;
    private List<UserRoleEntity> roles;
    private List<CandidateEntity> candidates;

    public UserEntity() {
    }

    @Column(length = 20 , nullable = false , unique = true)
    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column(length = 20 , nullable = false)
    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    @Column(nullable = false , unique = true)
    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    //ToDo check maybe have problem for two annotation with @OneToMany and fix
    @OneToMany
    public List<UserRoleEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(List<UserRoleEntity> roles) {
        this.roles = roles;
        return this;
    }

    @OneToMany
    public List<CandidateEntity> getCandidates() {
        return candidates;
    }

    public UserEntity setCandidates(List<CandidateEntity> candidates) {
        this.candidates = candidates;
        return this;
    }
}
