package com.esiea.challengedevopsapi.entities;

import com.esiea.challengedevopsapi.UserRole;
import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String login;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @ElementCollection
    private List<Integer> quizCreated;

    @ElementCollection
    @CollectionTable(name = "user_scores", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyColumn(name = "item_id")
    @Column(name = "score_value")
    private Map<Integer, Integer> scores;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public List<Integer> getQuizCreated() {
        return quizCreated;
    }

    public void setQuizCreated(List<Integer> quizCreated) {
        this.quizCreated = quizCreated;
    }

    public Map<Integer, Integer> getScores() {
        return scores;
    }

    public void setScores(Map<Integer, Integer> scores) {
        this.scores = scores;
    }}
