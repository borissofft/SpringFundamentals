package com.resellerapp.model.view;

import com.resellerapp.model.enums.ConditionEnum;

import java.math.BigDecimal;

public class OfferViewModel {

    private Long id;
    private ConditionEnum condition;
    private String description;
    private BigDecimal price;

    public OfferViewModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConditionEnum getCondition() {
        return condition;
    }

    public void setCondition(ConditionEnum condition) {
        this.condition = condition;
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
}
