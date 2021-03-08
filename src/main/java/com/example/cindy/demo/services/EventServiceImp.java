package com.example.cindy.demo.services;

import com.example.cindy.demo.jpa.entities.EventC;
import com.example.cindy.demo.jpa.repositories.EventRepository;
import constants.StateEvent;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class EventServiceImp implements EventService {

    final EventRepository eventRepository;

    public EventServiceImp(EventRepository eventRepository) {
        this.eventRepository = eventRepository;

    }

    @Override
    public List<EventC> getEvents() {
        return StreamSupport.stream(eventRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public Boolean createEvent(EventC eve) {
        if(eve != null){
            eventRepository.save(eve);
            return true;}
        else
            return false;
    }


   @Override
    public EventC cancelEvent(Long id) {
       EventC eve = eventRepository.findById(id).orElse(null);
       if (eve == null)
           return null;
       else
           eve.setState(StateEvent.cancelado);
       return eventRepository.save(eve);
    }


    @Override
    public EventC modifyEvent(Long id, java.sql.Date date) {
        EventC eve = eventRepository.findById(id).orElse(null);
        if(eve == null)
            return null;
        else
            eve.setDate(date);
        return eventRepository.save(eve);
    }


    @Override
    public EventC findByID(Long id) {
        EventC eve= eventRepository.findById(id).orElse(null);
        if(eve == null){
            return null;
        }
        return eve;
    }
    @Override
    public List<Date> filterByRoom(Long id) {
        List<Date> dates = filterByRoom(id);
        if(dates == null)
            return null;

        return dates;
    }


}

