package com.springbootdemo.EMS.service;

import com.springbootdemo.EMS.entity.leave;

import java.util.List;

public interface leaveService {
    List<leave> allLeavesForEmployee(int empId);
}
