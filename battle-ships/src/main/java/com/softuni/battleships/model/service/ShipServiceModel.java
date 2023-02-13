package com.softuni.battleships.model.service;

import com.softuni.battleships.model.entity.Category;
import com.softuni.battleships.model.entity.User;
import com.softuni.battleships.model.enums.CategoryEnum;

import java.time.LocalDate;

public class ShipServiceModel {

    private Long id;
    private String name;
    private Long Health;
    private Long Power;
    private LocalDate created;
    private CategoryEnum category;
    private User user;

    public ShipServiceModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHealth() {
        return Health;
    }

    public void setHealth(Long health) {
        Health = health;
    }

    public Long getPower() {
        return Power;
    }

    public void setPower(Long power) {
        Power = power;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
