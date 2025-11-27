package com.springbootdemo.EMS.service;

import com.springbootdemo.EMS.entity.department;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface departmentService {
    List<department> getDepartment();

    department getDepartmentbyId(int id);

    int addDepartment(department dep);

    department updateDepartment(@Valid department dep, int id);

    boolean deleteDepartment(int id);
}
