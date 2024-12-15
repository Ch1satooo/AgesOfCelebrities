package com.Ch1satooo.AgeOfCelebrities.repository;

import com.Ch1satooo.AgeOfCelebrities.model.Celebrity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CelebrityRepository extends JpaRepository<Celebrity, Integer> {

    // Define custom query methods here if needed

}