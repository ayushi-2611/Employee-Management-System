package com.ems.attendance.repository;

import com.ems.attendance.entity.leave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface leaveRepository extends JpaRepository<leave, Integer> {

    List<leave> findByEmployeeId(int employee_id);
    List<leave> findByStatus(String status);
}
