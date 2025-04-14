package com.esiea.challengedevopsapi.controllers;

import com.esiea.challengedevopsapi.services.QuizzService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(QuizzController.class)
@ExtendWith({SpringExtension.class, MockitoExtension.class})
class QuizzControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private QuizzService quizzService;

    @Test
    void getAllQuizzs() {
    }

    @Test
    void getQuizzById() {
    }

    @Test
    void createQuizz() {
    }
}