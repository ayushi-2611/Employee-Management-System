package com.ems.attendance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
public class leave {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private employee employee;

    @Pattern(regexp = "Sick|Casual|Personal|Vacation", message = "Leave Type can only be sick, casual, personal or vacation")
    private String leaveType;

    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @Temporal(TemporalType.DATE)
    private Date toDate;

    @Pattern(regexp = "Pending|Approved|Denied", message = "Status for Leave can be pending, approved or denied")
    private String status;

}
