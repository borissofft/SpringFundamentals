package com.softuni.battleships.model.binding;

import com.softuni.battleships.model.enums.CategoryEnum;
import com.softuni.battleships.model.validation.UniqueShipName;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ShipAddBindingModel {
    private String name;
    private Long power;
    private Long health;
    private LocalDate created;
    private CategoryEnum category;

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
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    @NotNull
    @Positive
    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
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
    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }
}
