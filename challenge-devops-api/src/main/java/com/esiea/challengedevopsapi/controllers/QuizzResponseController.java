package com.esiea.challengedevopsapi.controllers;

import com.esiea.challengedevopsapi.entities.QuizzResponse;
import com.esiea.challengedevopsapi.services.QuizzResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quizzresponse")
public class QuizzResponseController {

    private final QuizzResponseService quizResponseService;

    @Autowired
    public QuizzResponseController(QuizzResponseService quizResponseService) {
        this.quizResponseService = quizResponseService;
    }

    @PostMapping
    public ResponseEntity<QuizzResponse> submitQuizResponse(@RequestBody QuizzResponse response) {
        QuizzResponse savedResponse = quizResponseService.saveResponse(response);
        return new ResponseEntity<>(savedResponse, HttpStatus.CREATED);
    }
}
