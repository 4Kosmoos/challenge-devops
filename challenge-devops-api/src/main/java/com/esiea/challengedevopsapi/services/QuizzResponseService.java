package com.esiea.challengedevopsapi.services;

import com.esiea.challengedevopsapi.entities.QuizzResponse;
import com.esiea.challengedevopsapi.repositories.QuizzResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizzResponseService {


    private final QuizzResponseRepository quizResponseRepository;

    @Autowired
    public QuizzResponseService(QuizzResponseRepository quizResponseRepository) {
        this.quizResponseRepository = quizResponseRepository;
    }

    public QuizzResponse saveResponse(QuizzResponse response) {
        return quizResponseRepository.save(response);
    }
}
