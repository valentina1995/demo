package com.example.cindy.demo.facade;

import com.example.cindy.demo.dto.RoomDTO;
import com.example.cindy.demo.jpa.entities.Room;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DTORoomService {

    //
    boolean createRoom(RoomDTO roomDTO);

    //List  rooms
    List<RoomDTO> getRooms();

    Room findById(long id);
}
