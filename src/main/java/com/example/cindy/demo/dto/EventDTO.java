package com.example.cindy.demo.dto;

import constants.StateEvent;
import lombok.Data;


@Data
public class EventDTO {

    private String name;
    private String date;
    private Long roomId;
    private StateEvent state;

}
