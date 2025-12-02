package com.ems.attendance.service;


import com.ems.attendance.entity.leave;

import java.util.List;

public interface leaveService {
    List<leave> allLeavesForEmployee(int empId);

    List<leave> getLeavesByStatus(String status);
}
