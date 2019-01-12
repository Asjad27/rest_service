package com.asjad.rest.controllers;

import com.asjad.rest.entities.People;
import com.asjad.rest.repositories.PeopleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4000")
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
            if(newPerson.getName() != null)
                oldPerson.setName(newPerson.getName());
            if(newPerson.getCity() != null)
                oldPerson.setCity(newPerson.getCity());
            if(newPerson.getAge() != 0)
                oldPerson.setAge(newPerson.getAge());
            if(newPerson.getOccupation() != null)
                oldPerson.setOccupation(newPerson.getOccupation());
            if(newPerson.getAnnualTax() != 0.0)
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
