package com.esiea.challengedevopsapi.repositories;

import com.esiea.challengedevopsapi.entities.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizzRepository extends JpaRepository<Quizz, Integer> {
}
