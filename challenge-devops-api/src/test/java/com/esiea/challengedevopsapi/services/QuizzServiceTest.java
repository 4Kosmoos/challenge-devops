package com.esiea.challengedevopsapi.services;

import com.esiea.challengedevopsapi.entities.Quizz;
import com.esiea.challengedevopsapi.repositories.QuizzRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuizzServiceTest {

    @Mock
    private QuizzRepository repo;

    @InjectMocks
    private QuizzService quizzService;

    @Test
    void getAllQuizzs() {
        Quizz quizz1 = new Quizz();
        quizz1.setId(1);
        quizz1.setTheme("Theme1");

        Quizz quizz2 = new Quizz();
        quizz2.setId(2);
        quizz2.setTheme("Theme2");

        List<Quizz> expectedList = Arrays.asList(quizz1, quizz2);
        when(repo.findAll()).thenReturn(expectedList);

        List<Quizz> actualList = quizzService.getAllQuizzs();

        assertEquals(expectedList.size(), actualList.size());
        assertEquals(expectedList, actualList);
        verify(repo, times(1)).findAll();
    }

    @Test
    void getQuizzById() {
        Quizz quizz = new Quizz();
        quizz.setId(1);
        quizz.setTheme("Theme1");

        when(repo.findById(1)).thenReturn(Optional.of(quizz));

        Quizz result = quizzService.getQuizzById(1);
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Theme1", result.getTheme());
        verify(repo, times(1)).findById(1);
    }

    @Test
    void createQuizz() {
        Quizz quizz = new Quizz();
        quizz.setTheme("New Theme");

        when(repo.save(quizz)).thenReturn(quizz);

        Quizz created = quizzService.createQuizz(quizz);

        assertNotNull(created);
        assertEquals("New Theme", created.getTheme());
        verify(repo, times(1)).save(quizz);
    }
}