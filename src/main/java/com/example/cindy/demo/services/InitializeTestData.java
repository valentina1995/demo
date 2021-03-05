package com.example.cindy.demo.services;
import com.example.cindy.demo.jpa.entities.DateE;
import com.example.cindy.demo.jpa.entities.EventC;
import com.example.cindy.demo.jpa.entities.Room;
import constants.StateEvent;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Component
public class InitializeTestData {

    private final RoomService roomService;
    private final DateEServiceImp dateEService;
    private final EventService eventService;

    public InitializeTestData(RoomService roomService, DateEServiceImp dateEService, EventService eventService) {
        this.roomService = roomService;
        this.dateEService = dateEService;
        this.eventService = eventService;
    }

    @PostConstruct
    public void init() throws ParseException {



        Room room1 = new Room("Arquimedes");
        Room room2 = new Room("hermes");
        Room room3 = new Room("acuario");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


        DateE date1 = new DateE(new Date("2021-02-01"));
        DateE date2 = new DateE(new Date("2021-05-06"));
        DateE date3 = new DateE(new Date("2021-07-02"));


        eventService.createEvent(new EventC("Cumpleaños", date1, room1, StateEvent.pendiente));
        eventService.createEvent(new EventC("15", date2, room2, StateEvent.pendiente));
        eventService.createEvent(new EventC("grado", date3, room3, StateEvent.pendiente));
        eventService.createEvent(new EventC("50", date3, room1, StateEvent.pendiente));


    }



}
