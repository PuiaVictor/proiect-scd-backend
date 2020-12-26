package com.proiectSCD.proiectSCD.model.dto;

import com.proiectSCD.proiectSCD.model.entity.RolesEntity;

import java.util.Set;

public class UserCreationDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmedPassword;
    private Set<RolesEntity> assignedRoles;

    public UserCreationDTO(String firstName, String lastName, String email, String password, String confirmedPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    public Set<RolesEntity> getAssignedRoles() {
        return assignedRoles;
    }

    public void setAssignedRoles(Set<RolesEntity> assignedRoles) {
        this.assignedRoles = assignedRoles;
    }

    @Override
    public String toString() {
        return "UserCreationDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
