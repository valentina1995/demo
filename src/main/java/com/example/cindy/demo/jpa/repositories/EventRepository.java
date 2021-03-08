package com.example.cindy.demo.jpa.repositories;

import com.example.cindy.demo.jpa.entities.EventC;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<EventC, Long> {

    @Query(value = "Select e.date from EventC e where e.roomId = ?roomId", nativeQuery = true)
    List<Date> filterByRooms(Long roomId);

}
