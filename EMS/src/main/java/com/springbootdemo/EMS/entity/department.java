package com.springbootdemo.EMS.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    public String name;
    @Min(10)
    public String description;

}
