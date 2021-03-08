package com.example.cindy.demo.services;
import com.example.cindy.demo.jpa.entities.EventC;
import com.example.cindy.demo.jpa.entities.Room;
import constants.StateEvent;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class InitializeTestData {

    private final RoomService roomService;
    private final EventService eventService;

    public InitializeTestData(RoomService roomService,  EventService eventService) {
        this.roomService = roomService;
        this.eventService = eventService;
    }

    @PostConstruct
    public void init() throws ParseException {



        Room room1 = new Room("Arquimedes");
        Room room2 = new Room("hermes");
        Room room3 = new Room("acuario");
        Room room4 = new Room("acuario2");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


        Date date1 = formatter.parse("2021-02-01");
        Date date2 = formatter.parse("2021-05-06");
        Date date3 = formatter.parse("2021-07-02");
        Date date4 = formatter.parse("2021-07-03");


        try {
            eventService.createEvent(new EventC("Cumpleaños", date1, room1, StateEvent.pendiente));
            eventService.createEvent(new EventC("15", date2, room2, StateEvent.pendiente));
            eventService.createEvent(new EventC("grado", date3, room3, StateEvent.pendiente));
            eventService.createEvent(new EventC("50", date4, room4, StateEvent.pendiente));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



}
