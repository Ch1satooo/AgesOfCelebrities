package com.Ch1satooo.AgeOfCelebrities.model;


import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

// @Entity indicates that it is a JPA entity.
@Entity
@Table(name = "celebrity")
public class Celebrity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "profession")
    private String profession;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "created_at")
    private Date createdTime;

    @Column(name = "updated_at")
    private Date updatedTime;

}