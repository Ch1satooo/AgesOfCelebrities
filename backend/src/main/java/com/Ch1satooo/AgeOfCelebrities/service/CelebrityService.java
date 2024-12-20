package com.Ch1satooo.AgeOfCelebrities.service;

import com.Ch1satooo.AgeOfCelebrities.dto.CelebrityDTO;
import com.Ch1satooo.AgeOfCelebrities.model.Celebrity;

public interface CelebrityService {

    // All methods in an interface are implicitly public and abstract by default.
    CelebrityDTO getCelebrityById(int id);

    Integer addCelebrity(CelebrityDTO celebrityDTO);

    void deleteCelebrityById(String name);

    CelebrityDTO updateCelebrityByName(String name, CelebrityDTO celebrityDTO);

}
