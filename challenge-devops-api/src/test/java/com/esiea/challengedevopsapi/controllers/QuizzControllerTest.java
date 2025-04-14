package com.esiea.challengedevopsapi.controllers;

import com.esiea.challengedevopsapi.entities.Quizz;
import com.esiea.challengedevopsapi.services.QuizzService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
    void getAllQuizzs() throws Exception {
        Quizz quizz1 = new Quizz();
        quizz1.setId(1);
        quizz1.setTheme("Theme1");

        Quizz quizz2 = new Quizz();
        quizz2.setId(2);
        quizz2.setTheme("Theme2");

        List<Quizz> quizzList = Arrays.asList(quizz1, quizz2);

        when(quizzService.getAllQuizzs()).thenReturn(quizzList);

        mockMvc.perform(get("/api/quizz"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].theme").value("Theme1"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].theme").value("Theme2"));
    }

    @Test
    void getQuizzById() throws Exception {
        Quizz quizz = new Quizz();
        quizz.setId(1);
        quizz.setTheme("Theme1");

        when(quizzService.getQuizzById(1)).thenReturn(quizz);

        mockMvc.perform(get("/api/quizz/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.theme").value("Theme1"));
    }

    @Test
    void getQuizzByIdNotFound() throws Exception {
        when(quizzService.getQuizzById(1)).thenReturn(null);

        mockMvc.perform(get("/api/quizz/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void createQuizz() throws Exception {
        Quizz quizz = new Quizz();
        quizz.setTheme("New Theme");

        Quizz savedQuizz = new Quizz();
        savedQuizz.setId(1);
        savedQuizz.setTheme("New Theme");

        when(quizzService.createQuizz(Mockito.any(Quizz.class))).thenReturn(savedQuizz);

        mockMvc.perform(post("/api/quizz")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(quizz)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.theme").value("New Theme"));
    }
}