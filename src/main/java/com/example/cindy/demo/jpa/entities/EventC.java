package com.example.cindy.demo.jpa.entities;

import constants.StateEvent;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@NoArgsConstructor

public class EventC {
    @Id
    @GeneratedValue(strategy=SEQUENCE)
    private long id;
    private String name;
    private java.sql.Date date;
    @ManyToOne
    private Room room;
    private StateEvent state;

    public EventC(String name, java.sql.Date date, Room room) {
        this.name = name;
        this.date = date;
        this.room = room;
    }

    public EventC(String name, java.sql.Date date, Room room, StateEvent state) {
        this.name = name;
        this.date = date;
        this.room = room;
        this.state = state;
    }
}
