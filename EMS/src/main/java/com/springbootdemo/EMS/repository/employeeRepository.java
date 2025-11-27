package com.springbootdemo.EMS.repository;

import com.springbootdemo.EMS.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface employeeRepository extends JpaRepository<employee, Integer> {
    List<employee> findByDepartmentId(int departmentId);

}
