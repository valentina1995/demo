package com.example.cindy.demo.jpa.entities;

import constants.StateEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventC {
    @Id
    private String id;
    private String date;
    private String room;
    private StateEvent state;







}
