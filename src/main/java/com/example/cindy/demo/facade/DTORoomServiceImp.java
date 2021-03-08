package com.example.cindy.demo.facade;

import com.example.cindy.demo.dto.EventDTO;
import com.example.cindy.demo.dto.RoomDTO;
import com.example.cindy.demo.jpa.entities.EventC;
import com.example.cindy.demo.jpa.entities.Room;
import com.example.cindy.demo.services.RoomService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DTORoomServiceImp implements DTORoomService{

    @Autowired
    private RoomService roomService;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public boolean createRoom(RoomDTO roomDTO) {
        if(roomDTO == null)
            return false;
        Room room = modelMapper.map(roomDTO, (Type) Room.class);

        roomService.createRoom(room);

        return false;
    }

    @Override
    public List<RoomDTO> getRooms() {
        List<Room> rooms = roomService.getRooms();
        List<RoomDTO> collect ;
        collect = modelMapper.map(rooms, new TypeToken<List<RoomDTO>>() {}.getType());
        return collect;
    }

    @Override
    public Room findById(long id) {
        Room room = roomService.findByID(id);
        if(room == null)
            return null;
        return room;
    }
}
