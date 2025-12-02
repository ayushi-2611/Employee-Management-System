package com.ems.attendance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    // Employee FK relationship
    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "id", nullable = false)
    private employee employee;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Pattern(regexp = "Present|Absent|Halfday", message = "Status must be Present, Absent, or Halfday")
    private String status;

    // Shift FK relationship
    @ManyToOne
    @JoinColumn(name = "shift_id", referencedColumnName = "id", nullable = false)
    private shift shift;

}
