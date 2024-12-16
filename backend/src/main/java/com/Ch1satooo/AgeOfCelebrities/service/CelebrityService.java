package com.Ch1satooo.AgeOfCelebrities.service;

import com.Ch1satooo.AgeOfCelebrities.dto.CelebrityDTO;

public interface CelebrityService {

    // All methods in an interface are implicitly public and abstract by default.
    CelebrityDTO getCelebrityById(int id);

}
