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
    EventC cancelEvent(String id);

    EventC modifyEvent(String id, DateE date);

    EventC findByID(String id);



}
