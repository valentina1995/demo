package com.example.cindy.demo;


import com.example.cindy.demo.jpa.entities.EventC;
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
        // start your monitoring in here
        EventC event1 = new EventC("1", "2020-03-01", "Salon arquimedes", StateEvent.finalizado);
        EventC event2 = new EventC("2", "2020-03-05", "Salon gallego", StateEvent.pendiente);
        EventC event3 = new EventC("3", "2020-03-20", "Salon olivares", StateEvent.cancelado);
        EventC event4 = new EventC("4", "2020-03-30", "Salon atlas", StateEvent.pendiente);

        eventService.createEvent(event1);
        eventService.createEvent(event2);
        eventService.createEvent(event3);
        eventService.createEvent(event4);

        eventService.cancelEvent("1");
        eventService.ModifyEvent("1", "2020-05-10");
    }



}

