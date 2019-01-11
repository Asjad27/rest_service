package com.asjad.rest.controllers;

import com.asjad.rest.entities.People;
import com.asjad.rest.repositories.PeopleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PeopleController {
    private final PeopleRepository peopleRepository;

    PeopleController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @GetMapping("/people")
    List<People> all() {
        return peopleRepository.findAll();
    }

    @GetMapping("/people/{id}")
    People one(@PathVariable Long id) {
        if(peopleRepository.findById(id).isPresent())
            return peopleRepository.findById(id).get();
        else
            return null;
    }
}
