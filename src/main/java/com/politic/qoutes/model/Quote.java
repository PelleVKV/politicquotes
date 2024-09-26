package com.politic.qoutes.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String politician;
    private String text;

    // Constructors
    public Quote() {}

    public Quote(String politician, String text) {
        this.politician = politician;
        this.text = text;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getPolitician() {
        return politician;
    }

    public void setPolitician(String politician) {
        this.politician = politician;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
