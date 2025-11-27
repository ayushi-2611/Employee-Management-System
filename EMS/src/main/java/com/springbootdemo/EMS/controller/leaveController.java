package com.springbootdemo.EMS.controller;

import com.springbootdemo.EMS.entity.leave;
import com.springbootdemo.EMS.service.leaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/leave")
public class leaveController {

    @Autowired
    private leaveService leaveService;

    @GetMapping("allLeavesForEmployee/{id}")
    public List<leave> allLeavesForEmployee(@PathVariable int emp_id){
        return leaveService.allLeavesForEmployee(emp_id);
    }


}
