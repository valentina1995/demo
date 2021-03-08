package com.example.cindy.demo.facade;

import com.example.cindy.demo.dto.EventDTO;
import com.example.cindy.demo.jpa.entities.EventC;
import constants.StateEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public interface DTOEventService {

    EventC convertDTOtoEntity(EventDTO eventDTO);


    //List events
    List<EventDTO> getEvents();

    //Create event
    Boolean createEvent(EventDTO event);

    //Delete event
    EventDTO cancelEvent(Long id);

    EventDTO modifyEvent(Long id, String date);

    EventDTO findByID(Long id);



}
