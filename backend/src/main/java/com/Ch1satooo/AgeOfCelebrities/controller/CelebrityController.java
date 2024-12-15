package com.Ch1satooo.AgeOfCelebrities.controller;

import com.Ch1satooo.AgeOfCelebrities.model.Celebrity;
import com.Ch1satooo.AgeOfCelebrities.service.CelebrityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// @RestController is an 'identifier', for handling HTTP requests
// marks the class as a controller where every method returns a domain object instead of a view.
// Instead of rendering a visual page (a "view"), methods in this class directly return data (e.g. JSON).
@RestController
public class CelebrityController {

    private final CelebrityService celebrityService;
    @Autowired
    public CelebrityController(CelebrityService celebrityService) {
        this.celebrityService = celebrityService;
    }

    // @GetMapping ensures HTTP requests to '/...' are mapping to this method
    @GetMapping("/celebrity/{id}")
    public Celebrity getCelebrityById(@PathVariable int id) {
        return celebrityService.getCelebrityById(id);
    }
}
