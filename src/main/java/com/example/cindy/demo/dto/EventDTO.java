package com.example.cindy.demo.dto;

import com.example.cindy.demo.jpa.entities.EventC;
import constants.StateEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private long id;
    private String name;
    private String date;
    private Long roomId;
    private StateEvent state;

    public EventDTO(String name, String date, Long roomId, StateEvent state) {
        this.name = name;
        this.date = date;
        this.roomId = roomId;
        this.state = state;
    }
}
