package com.Ch1satooo.AgeOfCelebrities.dto;

public class EventDTO {

    private int id;
    private int age;
    private String description;
    private boolean isCentral;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isCentral() {
        return isCentral;
    }

    public void setCentral(boolean central) {
        isCentral = central;
    }
}
