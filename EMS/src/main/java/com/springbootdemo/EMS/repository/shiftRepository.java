package com.springbootdemo.EMS.repository;

import com.springbootdemo.EMS.entity.employee;
import com.springbootdemo.EMS.entity.shift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface shiftRepository extends JpaRepository<shift, Integer> {

}
