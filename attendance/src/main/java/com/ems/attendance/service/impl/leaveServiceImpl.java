package com.ems.attendance.service.impl;


import com.ems.attendance.entity.leave;
import com.ems.attendance.repository.leaveRepository;
import com.ems.attendance.service.leaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class leaveServiceImpl implements leaveService {

    @Autowired
    private leaveRepository leaveRepository;


    @Override
    public List<leave> allLeavesForEmployee(int empId) {
        return leaveRepository.findByEmployeeId(empId);
    }

    @Override
    public List<leave> getLeavesByStatus(String status) {
        return leaveRepository.findByStatus(status);
    }

}
