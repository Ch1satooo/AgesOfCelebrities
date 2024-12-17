package com.Ch1satooo.AgeOfCelebrities.service;

import com.Ch1satooo.AgeOfCelebrities.converter.CelebrityConverter;
import com.Ch1satooo.AgeOfCelebrities.dto.CelebrityDTO;
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
    public CelebrityDTO getCelebrityById(int id) {
        Celebrity celebrity = celebrityRepository.findById(id).orElseThrow(RuntimeException::new);
        return CelebrityConverter.convertCelebrity(celebrity);
    }

    public Celebrity addCelebrity(CelebrityDTO celebrityDTO){
        Celebrity celebrity = new Celebrity();

        celebrity = celebrityRepository.save(celebrity);
        return celebrity;
    }

}
