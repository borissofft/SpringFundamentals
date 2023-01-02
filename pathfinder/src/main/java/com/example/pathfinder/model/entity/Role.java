package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.enums.RoleName;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    private RoleName name;

    public Role() {

    }

    @Enumerated(EnumType.STRING)
    @Column
    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }

}
