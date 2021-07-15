package com.example.objectsmapping.dto;

import java.util.Set;

public class ManagerDto {

    private String firstName;

    private String lastName;

    private Set<EmployeeDto>  subordinates;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<EmployeeDto> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<EmployeeDto> subordinates) {
        this.subordinates = subordinates;
    }
}
