package com.example.cindy.demo.services;
import com.example.cindy.demo.jpa.entities.DateE;

import java.util.List;

public interface DateEService {

    //List events
    List<DateE> getDates();

    //Find Date
    DateE findByID(Long id);

    //create date
    boolean saveDate(DateE dateE);


}
