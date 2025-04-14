package com.esiea.challengedevopsapi.controllers;

import com.esiea.challengedevopsapi.entities.Quizz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.esiea.challengedevopsapi.services.QuizzService;

import java.util.List;

@RestController
@RequestMapping("/api/quizz")
public class QuizzController {

    private final QuizzService quizzService;

    @Autowired
    public QuizzController(QuizzService quizzService) {
        this.quizzService = quizzService;
    }

    @GetMapping
    public ResponseEntity<List<Quizz>> getAllQuizzs() {
        List<Quizz> quizzes = quizzService.getAllQuizzs();
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quizz> getQuizzById(@PathVariable("id") int id) {
        Quizz quizz = quizzService.getQuizzById(id);
        if (quizz != null) {
            return new ResponseEntity<>(quizz, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Quizz> createQuizz(@RequestBody Quizz quizz) {
        Quizz createdQuizz = quizzService.createQuizz(quizz);
        return new ResponseEntity<>(createdQuizz, HttpStatus.CREATED);
    }
}