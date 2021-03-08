package com.example.cindy.demo.controllers;

import com.example.cindy.demo.dto.EventDTO;
import com.example.cindy.demo.jpa.entities.EventC;
import com.example.cindy.demo.jpa.entities.Room;
import com.example.cindy.demo.services.EventService;
import com.example.cindy.demo.services.RoomService;
import constants.StateEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping
public class EventcontrollerV {

    final EventService eventService;
    final RoomService roomService;

    public EventcontrollerV(EventService eventService, RoomService roomService) {
        this.eventService = eventService;
        this.roomService = roomService;
    }


    @GetMapping("/list")
    public String viewHomePage(Model model){

        model.addAttribute("listEvents", eventService.getEvents() );

        return "allEvents";

    }


    @GetMapping("/create")
    public ModelAndView createEvent() throws ParseException {

        ModelAndView modelAndView = new ModelAndView("createEvent");

        List<Room> roomList = roomService.getRooms();
        modelAndView.addObject("roomList",roomList);

        modelAndView.addObject("eventDTO",new EventDTO());

        return modelAndView;
    }

    @PostMapping("/create")
    public String createEvent(EventDTO eventDTO) {

        EventC event = roomService.convertRoomDTOtoEntity(eventDTO);
        event.setState(StateEvent.pendiente);
        eventService.createEvent(event);

        return "createEvent";
    }



    @GetMapping("/cancel/{id}")
    public  String cancelEvent(Model model, @PathVariable Long id){
        EventC eve = eventService.findByID(id);
        model.addAttribute("eventEdit", eve);
        return "cancelEvent";
    }
    @PostMapping("/cancel/{id}")
    public String cancelEvent(@ModelAttribute EventDTO eventDTO) {

        EventC event = roomService.convertRoomDTOtoEntity(eventDTO);
        eventService.cancelEvent(event.getId());
        return "redirect:/list";
    }
/*

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
    }*/
}
