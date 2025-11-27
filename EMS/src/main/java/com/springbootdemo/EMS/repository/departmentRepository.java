package com.springbootdemo.EMS.repository;

import com.springbootdemo.EMS.entity.department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface departmentRepository extends JpaRepository<department, Integer> {

}
