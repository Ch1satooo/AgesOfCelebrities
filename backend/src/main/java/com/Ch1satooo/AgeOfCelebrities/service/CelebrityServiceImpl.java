package com.Ch1satooo.AgeOfCelebrities.service;

import com.Ch1satooo.AgeOfCelebrities.dto.EventDTO;
import com.Ch1satooo.AgeOfCelebrities.dto.TimelineDTO;
import com.Ch1satooo.AgeOfCelebrities.model.Event;
import com.Ch1satooo.AgeOfCelebrities.repository.EventRepository;
import com.Ch1satooo.AgeOfCelebrities.utils.converter.CelebrityConverter;
import com.Ch1satooo.AgeOfCelebrities.dto.CelebrityDTO;
import com.Ch1satooo.AgeOfCelebrities.model.Celebrity;
import com.Ch1satooo.AgeOfCelebrities.repository.CelebrityRepository;
import com.Ch1satooo.AgeOfCelebrities.utils.converter.EventConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
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
    private final EventRepository eventRepository;
    @Autowired
    public CelebrityServiceImpl(CelebrityRepository celebrityRepository, EventRepository eventRepository) {
        this.celebrityRepository = celebrityRepository; // Dependency injected here
        this.eventRepository = eventRepository;
    }


    @Override
    @Transactional
    public TimelineDTO getTimeline(String name, Integer age) {
        CelebrityDTO celebrityDTO = getCelebrityByName(name);

        TimelineDTO timelineDTO = new TimelineDTO();
        timelineDTO.setCelebrity(celebrityDTO);
        Celebrity celebrityInDB = celebrityRepository.findByName(name);
        List<Event> eventList = eventRepository.findByCelebrity(celebrityInDB);
        if (eventList.isEmpty()) {
            throw new IllegalStateException("Celebrity name: " + name + " doesn't have any events now.");
        }
        // Convert Sequentially
        List<EventDTO> eventDTOList = new java.util.ArrayList<>(eventList.stream()
                .map(EventConvert::convertEvent)
                .toList());

        // Sort events by age
        eventDTOList.sort(Comparator.comparingInt(EventDTO::getAge));

        // Add the closest age event identifier
        int minGap = Integer.MAX_VALUE;
        EventDTO closestEventDTO = null;

        for (EventDTO eventDTO : eventDTOList) {
            int currentGap = Math.abs(eventDTO.getAge() - age);
            if (currentGap < minGap) {
                // If found a closer event, set the previous closest to non-central (if necessary)
                if (closestEventDTO != null) {
                    closestEventDTO.setCentral(false);
                }
                eventDTO.setCentral(true);
                closestEventDTO = eventDTO;  // Update closest event
                minGap = currentGap;
            }
        }

        timelineDTO.setEvents(eventDTOList);
        return timelineDTO;
    }


    @Override
    public CelebrityDTO getCelebrityByName(String name) {
        Celebrity celebrityInDB = celebrityRepository.findByName(name);

        // This thrown exception will be propagated to controller layer until it be caught.
        if (celebrityInDB == null) {
            throw new IllegalArgumentException("Celebrity name: " + name + " doesn't exists in the database.");
        }

        return CelebrityConverter.convertCelebrity(celebrityInDB);
    }

    @Override
    @Transactional
    public Integer addCelebrity(CelebrityDTO celebrityDTO) {
        Celebrity celebrityInDB = celebrityRepository.findByName(celebrityDTO.getName());
        if (!(celebrityInDB == null)) {
            throw new IllegalArgumentException("Celebrity name: " + celebrityDTO.getName() + " already exists in the database.");
        }
        Celebrity celebrity = celebrityRepository.save(CelebrityConverter.convertCelebrityDTO(celebrityDTO));
        return celebrity.getId();
    }

    @Override
    @Transactional
    public void deleteCelebrityByName(String name) {
        Celebrity celebrityInDB = celebrityRepository.findByName(name);
        if (celebrityInDB == null) {
            throw new IllegalArgumentException("Celebrity name: " + name + " doesn't exist in the database.");
        }
        celebrityRepository.deleteByName(name);
    }

    // @Transactional is used for multiple operations. If one fails, others roll back.
    @Override
    @Transactional
    public CelebrityDTO updateCelebrityByName(String name, CelebrityDTO celebrityDTO) {
        // Find existing celebrity by name
        Celebrity celebrityInDB= celebrityRepository.findByName(name);
        if (celebrityInDB == null) {
            throw new IllegalArgumentException("Celebrity name: " + name + " doesn't exist in the database.");
        }

        Celebrity celebrity = CelebrityConverter.convertCelebrityDTO(celebrityDTO);
        String requestName = celebrityDTO.getName();

        // Compare with the existing database entity
        // This equals() method must be override to make logical equality.
        if (celebrityInDB.equals(celebrity)) {
            throw new IllegalArgumentException("Exactly the same data as stored in the database.");
        }
        // Cannot change name to existing celebrity
        // Check if the requested name exists in another record
        Celebrity existingCelebrityWithRequestName = celebrityRepository.findByName(requestName);
        if (existingCelebrityWithRequestName != null && !existingCelebrityWithRequestName.getName().equals(celebrityInDB.getName())) {
            throw new IllegalArgumentException("The name requested to be changed already exists in the database.");
        }

        // Ensure the ID matches the existing entry to perform an update
        // If not check ID, save() may create a new entity in DB.
        celebrity.setId(celebrityInDB.getId());
        celebrityRepository.save(celebrity);
        return CelebrityConverter.convertCelebrity(celebrity);
    }

}
