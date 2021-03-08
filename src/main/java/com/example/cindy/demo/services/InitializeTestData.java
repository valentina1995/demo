package com.example.cindy.demo.services;
import com.example.cindy.demo.dto.EventDTO;
import com.example.cindy.demo.facade.DTOEventService;
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
    private final DTOEventService dtoEventService;

    public InitializeTestData(RoomService roomService, EventService eventService, DTOEventService dtoEventService) {
        this.roomService = roomService;
        this.eventService = eventService;
        this.dtoEventService = dtoEventService;
    }

    @PostConstruct
    public void init() throws ParseException {



        Room room1 = new Room("Arquimedes");
        Room room2 = new Room("hermes");
        Room room3 = new Room("acuario");
        Room room4 = new Room("acuario2");


        roomService.createRoom(room1);
        roomService.createRoom(room2);
        roomService.createRoom(room3);
        roomService.createRoom(room4);

        dtoEventService.createEvent(new EventDTO("Cumpleaños", "2020-02-01", room1.getId(), StateEvent.pendiente));
        dtoEventService.createEvent(new EventDTO("Fiesta de grado", "2020-02-14", room2.getId(), StateEvent.pendiente));
        dtoEventService.createEvent(new EventDTO("primera comunión", "2020-02-30", room3.getId(), StateEvent.pendiente));





    }



}
