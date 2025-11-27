package com.springbootdemo.EMS.controller;

import com.springbootdemo.EMS.entity.shift;
import com.springbootdemo.EMS.service.shiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shift")
public class shiftController {

    @Autowired
    private shiftService shiftService;

    @GetMapping("/getShift")
    public List<shift> getShift(){
        return shiftService.getShift();
    }

    @PostMapping("/addShift")
    public int addShift(@RequestBody shift shift){
        return shiftService.addShift(shift);
    }

    @DeleteMapping("/deleteShift/{id}")
    public boolean deleteShift(@PathVariable int id){
        return shiftService.deleteShift(id);
    }

}
