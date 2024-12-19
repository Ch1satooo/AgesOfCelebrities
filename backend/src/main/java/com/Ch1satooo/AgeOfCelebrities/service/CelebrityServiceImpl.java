package com.Ch1satooo.AgeOfCelebrities.service;

import com.Ch1satooo.AgeOfCelebrities.utils.converter.CelebrityConverter;
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
        Celebrity celebrity = celebrityRepository.findById(id).orElseThrow(() -> new IllegalStateException("Celebrity Id: " + id + " doesn't exist."));
        return CelebrityConverter.convertCelebrity(celebrity);
    }

    @Override
    public Integer addCelebrity(CelebrityDTO celebrityDTO) {
        Celebrity celebrityInDB = celebrityRepository.findByName(celebrityDTO.getName());
        if (!(celebrityInDB == null)) {
            throw new IllegalStateException(celebrityDTO.getName() + " already exists in the database.");
        }
        Celebrity celebrity = celebrityRepository.save(CelebrityConverter.convertCelebrityDTO(celebrityDTO));
        return celebrity.getId();
    }

    @Override
    public void deleteCelebrityById(int id) {
        celebrityRepository.findById(id).orElseThrow(() -> new IllegalStateException("Celebrity Id: " + id + " doesn't exist."));
        celebrityRepository.deleteById(id);
    }

    @Override
    public CelebrityDTO updateCelebrityByName(String name, CelebrityDTO celebrityDTO) {
        // Find existing celebrity by name
        Celebrity celebrityInDB= celebrityRepository.findByName(name);
        if (celebrityInDB == null) {
            throw new IllegalStateException("Celebrity name: " + name + " doesn't exist.");
        }

        Celebrity celebrity = CelebrityConverter.convertCelebrityDTO(celebrityDTO);

        // Compare with the existing database entry
        // This equals() method must be override to make logical equality.
        if (celebrityInDB.equals(celebrity)) {
            throw new IllegalStateException("Same as the data in the database.");
        }

        // Ensure the ID matches the existing entry to perform an update
        // If not check ID, save() may create a new entity in DB.
        celebrity.setId(celebrityInDB.getId());
        celebrityRepository.save(celebrity);
        return CelebrityConverter.convertCelebrity(celebrity);
    }

}
