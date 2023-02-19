package com.resellerapp.model.entity;

import com.resellerapp.model.enums.ConditionEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity{

    private ConditionEnum conditionName;
    private String description;
    private Set<Offer> offers;

    public Condition() {

    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    public ConditionEnum getConditionName() {
        return conditionName;
    }

    public void setConditionName(ConditionEnum conditionName) {
        this.conditionName = conditionName;
    }

    @Column(nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "condition", fetch = FetchType.EAGER)
    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}
