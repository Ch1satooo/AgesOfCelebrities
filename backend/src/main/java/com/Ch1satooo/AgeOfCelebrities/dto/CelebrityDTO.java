// DTO (Data Transfer Object), these protected data will be pushed to frontend
package com.Ch1satooo.AgeOfCelebrities.dto;

public class CelebrityDTO {

    // When update date, 'id' field isn't be needed
    // But it is nullable and no error will be triggered.
    private int id;

    private String name;

    // Date data from frontend is String type
    private String birthDate;

    private String gender;

    private String profession;

    private String nationality;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
