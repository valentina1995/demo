package com.example.cindy.demo;


import com.example.cindy.demo.jpa.entities.DateE;
import com.example.cindy.demo.jpa.entities.EventC;
import com.example.cindy.demo.jpa.entities.Room;
import com.example.cindy.demo.services.EventService;
import constants.StateEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Controller
public class DemoApplication {

    public final EventService eventService;

    public DemoApplication(EventService eventService) {
        this.eventService = eventService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);




    }

    @PostConstruct
    public void init(){

        Room room1 = new Room("1", "Salon arquimedes");
        Room room2 = new Room("2", "Salon Gallego");
        Room room3 = new Room("3", "Salon Gall");
        Room room4 = new Room("4", "Salon Galle");
        Room room5 = new Room("5", "Salon Galleg");
        DateE date1 = new DateE("1", "1", "08", "2021");
        DateE date2 = new DateE("2", "5", "08", "2021");
        DateE date3 = new DateE("3", "9", "08", "2021");
        DateE date4 = new DateE("4", "11", "08", "2021");
        DateE date5 = new DateE("5", "12", "08", "2021");

        // start your monitoring in here
        EventC event1 = new EventC("1", date1, room1, StateEvent.finalizado);
        EventC event2 = new EventC("2", date2, room2, StateEvent.pendiente);
        EventC event3 = new EventC("3", date3, room3, StateEvent.cancelado);
        EventC event4 = new EventC("4", date4, room4, StateEvent.pendiente);

        eventService.createEvent(event1);
 /*       eventService.createEvent(event2);
        eventService.createEvent(event3);
        eventService.createEvent(event4);

        eventService.cancelEvent("1");
        eventService.modifyEvent("1", date5);*/
    }



}

