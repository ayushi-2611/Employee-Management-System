package com.springbootdemo.EMS.controller;

import com.springbootdemo.EMS.entity.attendance;
import com.springbootdemo.EMS.service.attendanceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class attendanceController {

    @Autowired
    private attendanceService attendanceService;

    @GetMapping("/EmployeeId/{id}")
    public List<attendance> getAttendanceByEmployeeId(@PathVariable int id)
    {
        return attendanceService.getAttendanceByEmployeeId(id);
    }

    @GetMapping("/shift/{id}")
    public List<attendance> getAttendanceByShiftId(@PathVariable int id)
    {
        return attendanceService.getAttendanceByShiftId(id);
    }

    @PostMapping("add")
    public int markAttendance(@Valid @RequestBody attendance attendance){
        return attendanceService.markAttendance(attendance);
    }

    @PutMapping("editAttendanceByEmployeeId/{id}")
    public attendance editAttendanceByEmployeeId(@Valid @PathVariable int id, @RequestBody attendance attendance){
        return attendanceService.editAttendanceByEmployeeId(id, attendance);
    }

    @DeleteMapping("/deleteAttendance/{id}")
    public boolean deleteAttendance(@PathVariable int id){
        return attendanceService.deleteAttendance(id);
    }

}
