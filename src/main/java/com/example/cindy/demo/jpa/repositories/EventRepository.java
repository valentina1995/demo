package com.example.cindy.demo.jpa.repositories;

import com.example.cindy.demo.jpa.entities.EventC;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<EventC, Long> {

}
