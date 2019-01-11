package com.asjad.rest.controllers;

import com.asjad.rest.entities.People;
import com.asjad.rest.repositories.PeopleRepository;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/people")
    People newPerson(@RequestBody People newPerson) {
        return peopleRepository.save(newPerson);
    }

    @PutMapping("/people/{id}")
    People replacePerson(@RequestBody People newPerson, @PathVariable Long id) {
        People oldPerson;
        if(peopleRepository.findById(id).isPresent()) {
            oldPerson = peopleRepository.findById(id).get();
            oldPerson.setName(newPerson.getName());
            oldPerson.setCity(newPerson.getCity());
            oldPerson.setAge(newPerson.getAge());
            oldPerson.setOccupation(newPerson.getOccupation());
            oldPerson.setAnnualTax(newPerson.getAnnualTax());
            return peopleRepository.save(oldPerson);
        }
        else
            return null;
    }

    @DeleteMapping("/people/{id}")
    void deletePerson(@PathVariable Long id) {
        if(peopleRepository.findById(id).isPresent()) {
            peopleRepository.deleteById(id);
        }
    }
}
