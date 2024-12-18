package com.Ch1satooo.AgeOfCelebrities.repository;

import com.Ch1satooo.AgeOfCelebrities.model.Celebrity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CelebrityRepository extends JpaRepository<Celebrity, Integer> {

    // Define custom query methods here if needed

    // findById() method returns an Optional<Celebrity> value
    // But other derived query methods return List<Celebrity> or Celebrity type
    List<Celebrity> findByName(String name);

}
