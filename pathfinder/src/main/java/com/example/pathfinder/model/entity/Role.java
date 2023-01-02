package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.enums.RoleName;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    private RoleName role;

    public Role() {

    }

    @Enumerated(EnumType.STRING)
    @Column
    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }

}
