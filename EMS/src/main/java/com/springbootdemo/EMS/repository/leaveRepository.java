package com.springbootdemo.EMS.repository;

import com.springbootdemo.EMS.entity.leave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface leaveRepository extends JpaRepository<leave, Integer> {

    List<leave> findByEmployeeId(int employee_id);
}
