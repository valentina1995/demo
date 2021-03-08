package com.example.cindy.demo.facade;

import com.example.cindy.demo.dto.EventDTO;
import com.example.cindy.demo.jpa.entities.EventC;
import com.example.cindy.demo.jpa.entities.Room;
import com.example.cindy.demo.services.EventService;
import com.example.cindy.demo.services.RoomService;
import org.modelmapper.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DTOEventServiceImp implements DTOEventService {

    private EventService eventService;
    private RoomService roomService;

    public DTOEventServiceImp(EventService eventService, RoomService roomService) {
        this.eventService = eventService;
        this.roomService = roomService;
    }



    ModelMapper modelMapper = new ModelMapper();


    @Override
    public EventC convertDTOtoEntity(EventDTO eventDTO) {
        return null;
    }

    @Override
    public List<EventDTO> getEvents() {
        List<EventC> events = eventService.getEvents();
        Type listType = new TypeToken<List<EventC>>(){}.getType();

        return modelMapper.map(events,listType);

    }

    @Override
    public Boolean createEvent(EventDTO eventDTO) {
        if(eventDTO == null)
            return false;

        EventC eve = modelMapper.map(eventDTO, (Type) EventC.class);
        eve.setRoom(roomService.findByID(eventDTO.getRoomId()));

        eventService.createEvent(eve);
        return true;
    }

    @Override
    public EventDTO cancelEvent(Long id) {
        EventC eventC = eventService.findByID(id);
        if( eventC == null)
            return null;

        EventC eve = eventService.cancelEvent(id);
        return modelMapper.map(eve, (Type) EventDTO.class);

    }

    @Override
    public EventDTO modifyEvent(Long id, String date) {
        EventC eventC = eventService.findByID(id);
        if( eventC == null)
            return null;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = null;
        try {
            parsed = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date dateEntity = new java.sql.Date(parsed.getTime());
        eventService.modifyEvent(id, dateEntity);

        return modelMapper.map(eventC, (Type) EventDTO.class);
    }

    @Override
    public EventDTO findByID(Long id) {
        EventC eventC = eventService.findByID(id);
        EventDTO eventDTO = modelMapper.map(eventC, (Type) EventDTO.class);
        if(eventC == null){
            return null;
        }

        return eventDTO;
    }

    @Override
    public List<Date> filterByRoom(Long id) {

        return eventService.filterByRoom(id);
    }

    private Date parseEventDate(String eventDateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date eventDate = formatter.parse(eventDateString);
        return eventDate;
    }

    private Room parseRoom(Long roomId){

        //return roomService.findByID(roomId);
        return null;
    }
}
