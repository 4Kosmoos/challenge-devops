package com.esiea.challengedevopsapi.repositories;

import com.esiea.challengedevopsapi.entities.QuizzResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizzResponseRepository extends JpaRepository<QuizzResponse, Integer>{
}
