package com.example.cindy.demo.services;

import com.example.cindy.demo.jpa.entities.DateE;
import com.example.cindy.demo.jpa.repositories.DateERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
public class DateEServiceImp implements DateEService{
    @Autowired
    DateERepository dateERepository;

    @Override
    public List<DateE> getDates() {
        return StreamSupport.stream(dateERepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public DateE findByID(Long id) {
        return dateERepository.findById(id).orElse(null);
    }

    @Override
    public boolean saveDate(DateE dateE) {
        if(dateE == null)
            return false;
        else
            dateERepository.save(dateE);
        return true;
    }
}
