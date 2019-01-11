package com.asjad.rest.data;

import com.asjad.rest.entities.People;
import com.asjad.rest.repositories.PeopleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class PopulatePeopleTable {

    @Bean
    CommandLineRunner initDatabase(PeopleRepository repository) {
        return args -> {
            repository.save(new People("Person One", "City-1", 30, "Occupation-1", 333.33));
        };
    }
}