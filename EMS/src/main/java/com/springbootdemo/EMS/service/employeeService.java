package com.springbootdemo.EMS.service;

import com.springbootdemo.EMS.entity.employee;

import java.util.List;

public interface employeeService {

    public List<employee> getEmployees();

    public employee addEmployee(employee emp);


    employee getEmployeewithId(int id);

    boolean deleteEmployee(int id);

    employee updateEmployee(employee emp, int id);
}
