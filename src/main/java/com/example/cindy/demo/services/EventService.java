package com.example.cindy.demo.services;

import com.example.cindy.demo.jpa.entities.DateE;
import com.example.cindy.demo.jpa.entities.EventC;


import java.util.List;

public interface EventService {


    //List events
    List<EventC> getEvents();

    //Create event
    Boolean createEvent(EventC event);

    //Delete event
    EventC cancelEvent(Long id);

    EventC modifyEvent(Long id, DateE date);

    EventC findByID(Long id);



}
