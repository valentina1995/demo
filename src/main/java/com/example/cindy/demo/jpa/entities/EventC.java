package com.example.cindy.demo.jpa.entities;

import constants.StateEvent;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor

public class EventC {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private DateE date;
    @ManyToOne
    private Room room;
    private StateEvent state;

    public EventC(String name, DateE date, Room room) {
        this.name = name;
        this.date = date;
        this.room = room;
    }

    public EventC(String name, DateE date, Room room, StateEvent state) {
    }

}
