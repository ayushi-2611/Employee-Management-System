package com.springbootdemo.EMS.service;

import com.springbootdemo.EMS.entity.shift;

import java.util.List;

public interface shiftService {
    List<shift> getShift();

    int addShift(shift shift);

    boolean deleteShift(int id);
}
