package com.esiea.challengedevopsapi.controllers;

import com.esiea.challengedevopsapi.entities.Quizz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.esiea.challengedevopsapi.services.QuizzService;

@RestController
@RequestMapping("/api/quizz")
public class QuizzController {

    private final QuizzService quizzService;

    @Autowired
    public QuizzController(QuizzService quizzService) {
        this.quizzService = quizzService;
    }

    @PostMapping
    public ResponseEntity<Quizz> createQuizz(@RequestBody Quizz quizz) {
        Quizz createdQuizz = quizzService.createQuizz(quizz);
        return new ResponseEntity<>(createdQuizz, HttpStatus.CREATED);
    }
}