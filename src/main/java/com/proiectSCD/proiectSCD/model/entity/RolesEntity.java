package com.proiectSCD.proiectSCD.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class RolesEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "ROLE")
    private String role;

    public RolesEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}