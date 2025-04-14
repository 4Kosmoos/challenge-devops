package com.esiea.challengedevopsapi.services;

import com.esiea.challengedevopsapi.repositories.QuizzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esiea.challengedevopsapi.entities.Quizz;

@Service
public class QuizzService {
    private final QuizzRepository quizzRepository;

    @Autowired
    public QuizzService(QuizzRepository quizzRepository) {
        this.quizzRepository = quizzRepository;
    }

    public Quizz createQuizz(Quizz quizz) {
        // test
        return quizzRepository.save(quizz);
    }
}
