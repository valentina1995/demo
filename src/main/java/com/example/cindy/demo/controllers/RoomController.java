package com.example.cindy.demo.controllers;


import com.example.cindy.demo.dto.EventDTO;
import com.example.cindy.demo.dto.RoomDTO;
import com.example.cindy.demo.facade.DTORoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping
public class RoomController {

    final DTORoomService dtoRoomService;

    public RoomController(DTORoomService dtoRoomService) {
        this.dtoRoomService = dtoRoomService;
    }

    @GetMapping("/createRoom")
    public ModelAndView createRoom() {

        ModelAndView modelAndView = new ModelAndView("createRoom");

        modelAndView.addObject("roomDTO",new RoomDTO());

        return modelAndView;
    }

    @PostMapping("/createRoom")
    public String createRoom(RoomDTO roomDTO) {

        dtoRoomService.createRoom(roomDTO);

        return "createRoom";
    }
}
