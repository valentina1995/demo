package com.example.cindy.demo.jpa.repositories;

import com.example.cindy.demo.jpa.entities.DateE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateERepository extends CrudRepository<DateE,  String> {
}
