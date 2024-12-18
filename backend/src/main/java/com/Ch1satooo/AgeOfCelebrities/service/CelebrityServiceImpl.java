package com.Ch1satooo.AgeOfCelebrities.service;

import com.Ch1satooo.AgeOfCelebrities.converter.CelebrityConverter;
import com.Ch1satooo.AgeOfCelebrities.dto.CelebrityDTO;
import com.Ch1satooo.AgeOfCelebrities.model.Celebrity;
import com.Ch1satooo.AgeOfCelebrities.repository.CelebrityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

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
        Celebrity celebrity = celebrityRepository.findById(id).orElseThrow(() -> new RuntimeException("Celebrity noe found."));
        return CelebrityConverter.convertCelebrity(celebrity);
    }

    public Integer addCelebrity(CelebrityDTO celebrityDTO) {
        List<Celebrity> celebrityList = celebrityRepository.findByName(celebrityDTO.getName());
        if (!CollectionUtils.isEmpty(celebrityList)) {
            throw new IllegalStateException(celebrityDTO.getName() + " already exists in the database.");
        }
        Celebrity celebrity = celebrityRepository.save(CelebrityConverter.convertCelebrityDTO(celebrityDTO));
        return celebrity.getId();
    }

}
