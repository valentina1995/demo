package com.example.cindy.demo.services;

import com.example.cindy.demo.dto.EventDTO;
import com.example.cindy.demo.jpa.entities.EventC;
import com.example.cindy.demo.jpa.entities.Room;
import com.example.cindy.demo.jpa.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
public class RoomServiceImp implements RoomService{

    @Autowired
    RoomRepository roomRepository;

    @Override
    public boolean createRoom(Room room) {
        if(room != null) {
            roomRepository.save(room);
            return true;
        }else
            return false;
    }

    @Override
    public List<Room> getRooms() {
        return StreamSupport.stream(roomRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public boolean deleteRoom(Long id) {
        Room room= roomRepository.findById(id).orElse(null);
        if(room == null)
            return false;
        else
            roomRepository.delete(room);
        return true;
    }

    @Override
    public Room modifyRoom(Long id, String name) {
        Room room = roomRepository.findById(id).orElse(null);
        if(room == null)
            return null;
        else
            room.setName(name);
        return roomRepository.save(room);
    }

    @Override
    public Room findByID(Long id) {
        return roomRepository.findById(id).orElse(null);
    }


    public EventC convertRoomDTOtoEntity(EventDTO eventDTO){
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
//        eventC.setRoom(this.room);
//        eventC.setState(state);
        return eventC;
    }

    private Date parseEventDate(String eventDateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date eventDate = formatter.parse(eventDateString);
        return eventDate;
    }

    private Room parseRoom(Long roomId){
        return roomRepository.findById(roomId).orElse(null);
    }

}
