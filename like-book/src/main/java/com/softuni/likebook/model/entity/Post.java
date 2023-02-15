package com.softuni.likebook.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity {

    private String content;
    private User user;
    private Mood mood;
    private Integer likes;
    private Set<User> userLikes;

    public Post() {

    }

    @Column(length = 150, nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne(optional = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    @Column
    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<User> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(Set<User> userLikes) {
        this.userLikes = userLikes;
    }
}
