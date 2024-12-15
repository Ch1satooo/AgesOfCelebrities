package com.Ch1satooo.AgeOfCelebrities.service;

import com.Ch1satooo.AgeOfCelebrities.model.Celebrity;
import com.Ch1satooo.AgeOfCelebrities.repository.CelebrityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CelebrityServiceImpl implements CelebrityService {

    // @Autowired is used for Dependency Injection (DI).
    // It tells the Spring framework to inject an instance of the dependency.
    // Field injection:
    // @Autowired
    // private CelebrityRepository celebrityRepository;

    //Constructor injection:
    private final CelebrityRepository celebrityRepository;  // Declaration just tells that the class will use this dependency.
    @Autowired
    public CelebrityServiceImpl(CelebrityRepository celebrityRepository) {
        this.celebrityRepository = celebrityRepository; // Dependency injected here
    }

    @Override
    public Celebrity getCelebrityById(int id) {
        return celebrityRepository.findById(id).orElseThrow(RuntimeException::new);
    }

}
