package com.example.cindy.demo.controllers;

import com.example.cindy.demo.jpa.entities.EventC;
import com.example.cindy.demo.services.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class EventcontrollerV {

    final EventService eventService;

    public EventcontrollerV(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping("/list")
    public String viewHomePage(Model model){
        model.addAttribute("listEvents", eventService.getEvents() );
        return "allEvents";

    }


    @PostMapping("/create")
    public String createEvent(@ModelAttribute EventC eventC) {
        eventService.createEvent(eventC);
        return "createEvent";
    }
    @GetMapping("/create")
    public String createEvent(Model model) {
        model.addAttribute("eventC", new EventC() );
        return "createEvent";
    }

    @GetMapping("/cancel/{id}")
    public  String cancelEvent(Model model, @PathVariable String id){
        EventC eve = eventService.findByID(id);
        model.addAttribute("eventEdit", eve);
        return "cancelEvent";
    }
    @PostMapping("/cancel/{id}")
    public String cancelEvent( @ModelAttribute EventC eventC) {
        eventService.cancelEvent(eventC.getId());
        return "redirect:/list";
    }


    @GetMapping("/change/{id}")
    public  String modifyEvent(Model model, @PathVariable String id){
        EventC eve = eventService.findByID(id);
        model.addAttribute("eventEdit", eve);
        return "editEvent";
    }

    @PostMapping("/change/{id}/{date}")
    public String modifyEvent(@ModelAttribute EventC eventC) {
        eventService.modifyEvent(eventC.getId(), eventC.getDate());
        return "redirect:/list";
    }
}
