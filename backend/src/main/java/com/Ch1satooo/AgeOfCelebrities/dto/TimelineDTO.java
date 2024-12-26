package com.Ch1satooo.AgeOfCelebrities.dto;

import java.util.List;

public class TimelineDTO {

    private CelebrityDTO celebrity;
    private List<EventDTO> events;

    public CelebrityDTO getCelebrity() {
        return celebrity;
    }

    public void setCelebrity(CelebrityDTO celebrity) {
        this.celebrity = celebrity;
    }

    public List<EventDTO> getEvents() {
        return events;
    }

    public void setEvents(List<EventDTO> events) {
        this.events = events;
    }
}
