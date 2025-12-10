package com.springbootdemo.EMS.service.Impl;

import com.springbootdemo.EMS.entity.attendance;
import com.springbootdemo.EMS.entity.leave;
import com.springbootdemo.EMS.service.leaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class leaveServiceImpl implements leaveService {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public List<leave> allLeavesForEmployee(int empId) {
        String url = "http://localhost:8085/ams/leave/allLeavesForEmployee/";
        ArrayList<leave> saveVariable = restTemplate.getForObject(url + empId, ArrayList.class);
        return saveVariable;
    }

    @Override
    public List<leave> getLeavesByStatus(String status) {
        String url = "http://localhost:8085/ams/leave?status={status}";
        leave[] leavesArray = restTemplate.getForObject(url, leave[].class, status);
        return leavesArray != null ? Arrays.asList(leavesArray) : Collections.emptyList();
    }

}
