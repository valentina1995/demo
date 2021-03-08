package com.example.cindy.demo.services;

import com.example.cindy.demo.dto.EventDTO;
import com.example.cindy.demo.jpa.entities.EventC;
import com.example.cindy.demo.jpa.entities.Room;
import com.example.cindy.demo.jpa.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
public class RoomServiceImp implements RoomService{

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    EventService eventService;

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



}
