package com.example.cindy.demo.jpa.repositories;

import com.example.cindy.demo.jpa.entities.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room,String> {
}
