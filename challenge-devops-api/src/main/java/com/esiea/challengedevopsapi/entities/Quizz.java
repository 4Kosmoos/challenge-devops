package com.esiea.challengedevopsapi.entities;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "quizzs")
public class Quizz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String theme;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Question> questions;

    public Quizz() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}