package com.resellerapp.model.service;

import com.resellerapp.model.entity.User;
import com.resellerapp.model.enums.ConditionEnum;

import java.math.BigDecimal;

public class OfferServiceModel {
    private Long id;
    private String description;
    private BigDecimal price;
    private ConditionEnum condition;
    private User user;

    public OfferServiceModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ConditionEnum getCondition() {
        return condition;
    }

    public void setCondition(ConditionEnum condition) {
        this.condition = condition;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
