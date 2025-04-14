package com.esiea.challengedevopsapi.entities;

import jakarta.persistence.*;
import java.util.Map;

@Entity
@Table(name = "quiz_responses")
public class QuizzResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "quizz_id")
    private Quizz quizz;

    @ElementCollection
    @CollectionTable(name = "quiz_response_answers", joinColumns = @JoinColumn(name = "quiz_response_id"))
    @MapKeyColumn(name = "question_id")
    @Column(name = "user_answer")
    private Map<Integer, String> responses;

    public QuizzResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Quizz getQuizz() {
        return quizz;
    }

    public void setQuizz(Quizz quizz) {
        this.quizz = quizz;
    }

    public Map<Integer, String> getResponses() {
        return responses;
    }

    public void setResponses(Map<Integer, String> responses) {
        this.responses = responses;
    }
}
