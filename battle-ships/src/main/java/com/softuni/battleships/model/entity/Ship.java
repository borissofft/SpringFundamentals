package com.softuni.battleships.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "ships")
public class Ship extends BaseEntity {
    private String name;
    private Long Health;
    private Long Power;
    private LocalDate created;
    private Category category;
    private User user;

    public Ship() {

    }

    @Column(length = 10, nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public Long getHealth() {
        return Health;
    }

    public void setHealth(Long health) {
        Health = health;
    }

    @Column(nullable = false)
    public Long getPower() {
        return Power;
    }

    public void setPower(Long power) {
        Power = power;
    }

    @Column(nullable = false)
    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
