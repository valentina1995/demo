package com.example.cindy.demo.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateE {
    @Id
    private String id;
    private String day;
    private String month;
    private String year;
}
