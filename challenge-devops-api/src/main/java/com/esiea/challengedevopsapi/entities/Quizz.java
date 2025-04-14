package com.esiea.challengedevopsapi.entities;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "quizzs")
public class Quizz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String theme;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Question> questions;

    @ManyToOne
    private User creator;

    public Quizz() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}