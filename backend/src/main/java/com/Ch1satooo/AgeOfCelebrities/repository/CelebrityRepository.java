package com.Ch1satooo.AgeOfCelebrities.repository;

import com.Ch1satooo.AgeOfCelebrities.model.Celebrity;
import com.Ch1satooo.AgeOfCelebrities.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// This repository is only used for Table 'Celebrity' query
@Repository
public interface CelebrityRepository extends JpaRepository<Celebrity, Integer> {

    // Define custom query methods here if needed

    // findById() method returns an Optional<Celebrity> value
    // But other derived query methods return List<Celebrity> or Celebrity type
    Celebrity findByName(String name);

    void deleteByName(String name);

}
