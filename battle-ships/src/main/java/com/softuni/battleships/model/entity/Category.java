package com.softuni.battleships.model.entity;

import com.softuni.battleships.model.enums.CategoryEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    private CategoryEnum name;
    private String description;

    public Category() {

    }

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
