package com.example.cindy.demo.services;

import com.example.cindy.demo.dto.EventDTO;
import com.example.cindy.demo.jpa.entities.EventC;
import com.example.cindy.demo.jpa.entities.Room;
import java.util.List;

public interface RoomService {

    //Create room
    boolean createRoom(Room room);

    //List  rooms
    List<Room> getRooms();

    //Delete room
    boolean deleteRoom(Long id);

    Room modifyRoom(Long id, String name);

    Room findByID(Long id);

    EventC convertRoomDTOtoEntity(EventDTO eventDTO);
}
