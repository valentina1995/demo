package com.example.cindy.demo.facade;

import com.example.cindy.demo.dto.EventDTO;
import com.example.cindy.demo.jpa.entities.EventC;
import com.example.cindy.demo.jpa.entities.Room;
import com.example.cindy.demo.services.EventService;
import com.example.cindy.demo.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DtoService implements IdtoServiceEvent{

    @Autowired
    private RoomService roomService;
    @Autowired
    private EventService eventService;



    public EventC convertDTOtoEntity(EventDTO eventDTO){
        EventC eventC = new EventC();
        eventC.setName(eventDTO.getName());
        try {
            Date eventDate = parseEventDate(eventDTO.getDate());
            eventC.setDate(eventDate);
            Room room = parseRoom(eventDTO.getRoomId());
            eventC.setRoom(room);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        eventC.setState(eventC.getState());
        eventC.setId(eventDTO.getId());
        return eventC;
    }

    @Override
    public List<EventDTO> getEvents() {

        List<EventDTO> collect = eventService.getEvents().stream().map(EventDTO::new).collect(Collectors.toList());
        return collect;

    }

    @Override
    public Boolean createEvent(EventDTO event) {
        EventC eve = new EventC();
        eve.setId(event.getId());
        eve.setName(event.getName());
        try {
            eve.setDate(parseEventDate(event.getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        eve.setRoom(parseRoom(event.getRoomId()));
        eve.setState(event.getState());
        eventService.createEvent(eve);


        return null;
    }

    @Override
    public EventDTO cancelEvent(Long id) {
        EventD eventC = eventService.findByID(id);
        if( eventC != null){
            eventService.cancelEvent(id);
            EventDTO eve = convertDTOtoEntity(eventC);
            return new EventDTO(eventC);
        }else{
            return null;
        }

    }

    @Override
    public EventDTO modifyEvent(Long id, Date date) {
        return null;
    }

    @Override
    public EventDTO findByID(Long id) {
        return null;
    }

    private Date parseEventDate(String eventDateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date eventDate = formatter.parse(eventDateString);
        return eventDate;
    }

    private Room parseRoom(Long roomId){
        return roomService.findByID(roomId);
    }
}
