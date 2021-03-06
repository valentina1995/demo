package com.example.cindy.demo.services;

import com.example.cindy.demo.jpa.entities.EventC;
import com.example.cindy.demo.jpa.entities.Room;
import org.springframework.data.jpa.repository.Query;


import java.util.Date;
import java.util.List;

public interface EventService {


    //List events
    List<EventC> getEvents();

    //Create event
    Boolean createEvent(EventC event);

    //Delete event
    EventC cancelEvent(Long id);

    EventC modifyEvent(Long id, java.sql.Date date);

    EventC findByID(Long id);

    List<Date> filterByRoom(Long id);



}
