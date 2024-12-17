package com.Ch1satooo.AgeOfCelebrities.controller;

import com.Ch1satooo.AgeOfCelebrities.Response;
import com.Ch1satooo.AgeOfCelebrities.dto.CelebrityDTO;
import com.Ch1satooo.AgeOfCelebrities.model.Celebrity;
import com.Ch1satooo.AgeOfCelebrities.service.CelebrityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // @GetMapping ensures HTTP requests to '/...' are mapping to this method in REST controller.
    // @PathVariable corresponds {id}
    @GetMapping("/celebrity/{id}")
    public Response<CelebrityDTO> getCelebrityById(@PathVariable int id) {
        return Response.newSuccess(celebrityService.getCelebrityById(id));
    }

    // @PostMapping is a Spring annotation used to handle HTTP POST requests
    // @RequestBody is used to bind the incoming JSON (or XML) in the HTTP request body to a Java object.
    // Spring Boot automatically converts the JSON payload to the corresponding object(DTO here).
    // Add validation here later!!!
    @PostMapping("/celebrity")
    public Response<Integer> addCelebrity(@RequestBody CelebrityDTO celebrityDTO){
        return Response.newSuccess(celebrityService.);
    }

}
