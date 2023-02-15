package com.softuni.likebook.model.entity;

import com.softuni.likebook.model.enums.MoodsEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "moods")
public class Mood extends BaseEntity {
    private MoodsEnum moodName;
    private String description;

    public Mood() {

    }

    @Column(name = "mood_name", unique = true, nullable = false)
    public MoodsEnum getMoodName() {
        return moodName;
    }

    public void setMoodName(MoodsEnum moodName) {
        this.moodName = moodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
