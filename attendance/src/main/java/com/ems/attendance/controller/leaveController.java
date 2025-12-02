package com.ems.attendance.controller;

import com.ems.attendance.entity.leave;
import com.ems.attendance.service.leaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ams/leave")
public class leaveController {

    @Autowired
    private leaveService leaveService;

    @GetMapping("allLeavesForEmployee/{id}")
    public List<leave> allLeavesForEmployee(@PathVariable int emp_id){
        return leaveService.allLeavesForEmployee(emp_id);
    }

    @GetMapping
    public ResponseEntity<List<leave>> getLeavesByStatus(@RequestParam("status") String status) {
        List<leave> leaves = leaveService.getLeavesByStatus(status);
        return ResponseEntity.ok(leaves);
    }


}
