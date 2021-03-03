package com.example.cindy.demo.controllers;

import com.example.cindy.demo.jpa.entities.EventC;
import com.example.cindy.demo.services.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EventController {


    final
    EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<EventC> getEvents(){
        return this.eventService.getEvents();
    }

    @PostMapping("/create")
    public Boolean createEvent(@RequestBody EventC event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/cancel/{id}")
    public EventC cancelEvent(@PathVariable String id) {
        return eventService.cancelEvent(id);
    }
    @PutMapping("/change/{id}/{date}")
    public EventC MofidyEvent(@PathVariable String id, @PathVariable String date) {
        return eventService.ModifyEvent(id, date);
    }



}
