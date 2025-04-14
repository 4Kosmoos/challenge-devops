package com.esiea.challengedevopsapi.services;

import com.esiea.challengedevopsapi.repositories.QuizzRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class QuizzServiceTest {

    @Mock
    private QuizzRepository repo;

    @InjectMocks
    private QuizzService quizzService;

    @Test
    void createQuizz() {
    }

    @Test
    void getAllQuizzs() {
    }

    @Test
    void getQuizzById() {
    }
}