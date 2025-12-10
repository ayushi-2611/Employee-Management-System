package com.springbootdemo.EMS.service.Impl;

import com.springbootdemo.EMS.entity.leave;
import com.springbootdemo.EMS.service.leaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class leaveServiceImpl implements leaveService {


    @Override
    public List<leave> allLeavesForEmployee(int empId) {
        return leaveRepository.findByEmployeeId(empId);
    }

    @Override
    public List<leave> getLeavesByStatus(String status) {
        return leaveRepository.findByStatus(status);
    }

}
