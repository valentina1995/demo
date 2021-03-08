package com.example.cindy.demo.controllers;

import com.example.cindy.demo.dto.EventDTO;
import com.example.cindy.demo.dto.RoomDTO;
import com.example.cindy.demo.facade.DTORoomService;
import com.example.cindy.demo.facade.DTOEventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping
public class EventcontrollerV {

    final DTOEventService dtoEventService;
    final DTORoomService dtoRoomService;

    public EventcontrollerV(DTOEventService dtoEventService, DTORoomService dtoRoomService) {
        this.dtoEventService = dtoEventService;
        this.dtoRoomService = dtoRoomService;
    }


    @GetMapping("/list")
    public String viewHomePage(Model model){

        model.addAttribute("listEvents", dtoEventService.getEvents() );

        return "allEvents";

    }


    @GetMapping("/create")
    public ModelAndView createEvent() throws ParseException {

        ModelAndView modelAndView = new ModelAndView("createEvent");

        List<RoomDTO> roomList = dtoRoomService.getRooms();
        modelAndView.addObject("roomList",roomList);

        modelAndView.addObject("eventDTO",new EventDTO());

        return modelAndView;
    }

    @PostMapping("/create")
    public String createEvent(EventDTO eventDTO) {

        dtoEventService.createEvent(eventDTO);

        return "createEvent";
    }



    @GetMapping("/cancel/{id}")
    public  String cancelEvent(Model model, @PathVariable Long id){
        EventDTO eventDTO = dtoEventService.findByID(id);

        model.addAttribute("eventEdit", eventDTO);
        return "cancelEvent";
    }
    @PostMapping("/cancel/{id}")
    public String cancelEvent(@ModelAttribute EventDTO eventDTO) {

        dtoEventService.cancelEvent(eventDTO.getId());

        return "redirect:/list";
    }


  @GetMapping("/change/{id}")
    public  String modifyEvent(Model model, @PathVariable Long id){
      EventDTO eventDTO = dtoEventService.findByID(id);
        model.addAttribute("eventEdit", eventDTO);
        return "editEvent";
    }

    @PostMapping("/change/{id}/{date}")
    public String modifyEvent(@ModelAttribute EventDTO eventDTO) {
        dtoEventService.modifyEvent(eventDTO.getId(), eventDTO.getDate());
        return "redirect:/list";
    }
}
