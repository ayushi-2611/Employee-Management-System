package com.springbootdemo.EMS.repository;

import com.springbootdemo.EMS.entity.attendance;
import com.springbootdemo.EMS.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface attendanceRepository extends JpaRepository<attendance, Integer> {
    List<attendance> findByEmployeeId(int employee_id);
    List<attendance> findByShiftId(int shift_id);

}
