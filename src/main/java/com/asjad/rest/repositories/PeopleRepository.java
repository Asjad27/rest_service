package com.asjad.rest.repositories;

import com.asjad.rest.entities.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long> {

}
