package com.Ch1satooo.AgeOfCelebrities.utils.converter;

import com.Ch1satooo.AgeOfCelebrities.dto.EventDTO;
import com.Ch1satooo.AgeOfCelebrities.model.Event;

public class EventConvert {

    public static EventDTO convertEvent(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setAge(event.getAge());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setCentral(false);
        return eventDTO;
    }

//    public static Event convertEventDTO(EventDTO eventDTO) {
//        Event event = new Event();
//        event.setId(eventDTO.getId());
//        event.setAge(eventDTO.getAge());
//
//        event.setDescription(eventDTO.getDescription());
//        return event;
//    }

}
