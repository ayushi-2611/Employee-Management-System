package com.springbootdemo.EMS.controller;

import com.springbootdemo.EMS.entity.employee;
import com.springbootdemo.EMS.service.employeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class employeeController {

    @Autowired
    private employeeService EmployeeService;

    @GetMapping("/getEmployees")
    public List<employee> getEmployees()
    {
        return EmployeeService.getEmployees();
    }

    @GetMapping("/getEmployeewithId/{id}")
    public employee getEmployeewithID(@PathVariable int id){
        return EmployeeService.getEmployeewithId(id);
    }

    @PostMapping("/addEmployee")
    public employee addEmployee(@Valid @RequestBody employee emp){
        return EmployeeService.addEmployee(emp);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public boolean deleteEmployee(@PathVariable int id){
        return EmployeeService.deleteEmployee(id);
    }

    @PutMapping("/updateEmployee/{id}")
    public employee updateEmployee(@Valid @RequestBody employee emp, @PathVariable int id){
        return EmployeeService.updateEmployee(emp, id);
    }


}
