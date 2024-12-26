package com.Ch1satooo.AgeOfCelebrities.controller;

import com.Ch1satooo.AgeOfCelebrities.Response;
import com.Ch1satooo.AgeOfCelebrities.dto.CelebrityDTO;
import com.Ch1satooo.AgeOfCelebrities.dto.TimelineDTO;
import com.Ch1satooo.AgeOfCelebrities.model.Celebrity;
import com.Ch1satooo.AgeOfCelebrities.service.CelebrityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    // core function
    // format: GET /timeline/TaylorSwift?age=25
    @GetMapping("timeline/{name}")
    public ResponseEntity<Response<TimelineDTO>> getTimeline(@PathVariable String name, @RequestParam Integer age){
        return ResponseEntity.ok(Response.newSuccess(celebrityService.getTimeline(name, age)));
    }

    // @GetMapping ensures HTTP requests to '/...' are mapping to this method in REST controller.
    // @PathVariable corresponds {id}
    @GetMapping("/celebrity/{name}")
    public ResponseEntity<Response<CelebrityDTO>> getCelebrityById(@PathVariable String name) {
        return ResponseEntity.ok(Response.newSuccess(celebrityService.getCelebrityByName(name)));
    }

    // @PostMapping is a Spring annotation used to handle HTTP POST requests
    // @RequestBody is used to bind the incoming JSON (or XML) in the HTTP request body to a Java object.
    // Spring Boot automatically converts the JSON payload to the corresponding object(DTO here).
    // Add validation here later!!!
    @PostMapping("/celebrity")
    public ResponseEntity<Response<Integer>> addCelebrity(@RequestBody CelebrityDTO celebrityDTO) {
        return ResponseEntity.ok(Response.newSuccess(celebrityService.addCelebrity(celebrityDTO)));
    }

    @DeleteMapping("/celebrity/{name}")
    public ResponseEntity<Response<Void>> deleteCelebrityByName(@PathVariable String name) {
        celebrityService.deleteCelebrityByName(name);
        return ResponseEntity.ok(Response.newSuccess(null));
    }

    // Update info by current name
    @PutMapping("/celebrity/{name}")
    public ResponseEntity<Response<CelebrityDTO>> updateCelebrityByName(@PathVariable String name, @RequestBody CelebrityDTO celebrityDTO) {
        return ResponseEntity.ok(Response.newSuccess(celebrityService.updateCelebrityByName(name, celebrityDTO)));
    }

}
