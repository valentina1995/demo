package com.example.cindy.demo.jpa.entities;

import constants.StateEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventC {
    @Id
    private String id;
    @OneToOne
    private DateE date;
    @ManyToOne
    private Room room;
    private StateEvent state;







}
