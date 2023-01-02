package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.enums.CategoryName;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    private CategoryName name;
    private String description;

    public Category() {

    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    public CategoryName getName() {
        return name;
    }

    public void setName(CategoryName name) {
        this.name = name;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
