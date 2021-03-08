package com.example.cindy.demo.facade;

import com.example.cindy.demo.dto.EventDTO;
import com.example.cindy.demo.jpa.entities.EventC;

import java.util.Date;
import java.util.List;

public interface IdtoServiceEvent {

    EventC convertDTOtoEntity(EventDTO eventDTO);


    //List events
    List<EventDTO> getEvents();

    //Create event
    Boolean createEvent(EventDTO event);

    //Delete event
    EventDTO cancelEvent(Long id);

    EventDTO modifyEvent(Long id, Date date);

    EventDTO findByID(Long id);


}
