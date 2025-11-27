package com.springbootdemo.EMS.controller;


import com.springbootdemo.EMS.entity.department;
import com.springbootdemo.EMS.service.departmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class departmentContoller {

    @Autowired
    public departmentService departmentService;

    @GetMapping("/allDepartments")
    public List<department> getDepartments(){
        return departmentService.getDepartment();
    }

    @GetMapping("/departmentbyId/{id}")
    public department getDepartmentbyId(@PathVariable int id){
        return departmentService.getDepartmentbyId(id);
    }

    @PostMapping("/addDepartment")
    public int addDepartment(@Valid @RequestBody department dep){
        return departmentService.addDepartment(dep);
    }

    @PutMapping("/updatedDepartment/{id}")
    public department updateDepartment(@Valid @RequestBody department dep, @PathVariable int id){
        return departmentService.updateDepartment(dep, id);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public boolean deleteDepartment(@PathVariable int id){
        return departmentService.deleteDepartment(id);
    }


}
