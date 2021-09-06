package com.softuni.judjev2.model.entity;

import jdk.jfr.Enabled;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(name = "username" , nullable = false , unique = true)
    private String username;
    @Column(name = "password" , unique = true)
    private String password;
    @Column(name = "email" , nullable = false , unique = true)
    private String email;
    @Column(name = "git" , nullable = false)
    private String git;
    @ManyToOne
    private Role role;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getGit() {
        return git;
    }

    public User setGit(String git) {
        this.git = git;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public User setRole(Role role) {
        this.role = role;
        return this;
    }
}
