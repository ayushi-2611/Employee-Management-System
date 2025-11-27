package com.springbootdemo.EMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
public class shift {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String shiftName;
    private Date startTime;
    private Date endTime;
    private String description;

}
