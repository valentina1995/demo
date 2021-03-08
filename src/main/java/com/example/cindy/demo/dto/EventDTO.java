package com.example.cindy.demo.dto;

import com.example.cindy.demo.jpa.entities.EventC;
import constants.StateEvent;
import lombok.Data;


@Data
public class EventDTO {
    private long id;
    private String name;
    private String date;
    private Long roomId;
    private StateEvent state;


}
