package com.Ch1satooo.AgeOfCelebrities.service;

import com.Ch1satooo.AgeOfCelebrities.model.Celebrity;

public interface CelebrityService {

    // All methods in an interface are implicitly public and abstract by default.
    Celebrity getCelebrityById(int id);

}
