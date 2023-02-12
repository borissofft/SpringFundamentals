package com.softuni.battleships.model.binding;

import com.softuni.battleships.model.entity.Category;
import com.softuni.battleships.model.validation.UniqueShipName;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ShipAddBindingModel {
    private String name;
    private Long Power;
    private Long Health;
    private LocalDate created;
    private Category category;

    public ShipAddBindingModel() {

    }

    @NotBlank
    @Size(min = 2, max = 10)
    @UniqueShipName
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Positive
    public Long getPower() {
        return Power;
    }

    public void setPower(Long power) {
        Power = power;
    }

    @NotNull
    @Positive
    public Long getHealth() {
        return Health;
    }

    public void setHealth(Long health) {
        Health = health;
    }

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @NotNull
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
