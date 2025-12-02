package com.ems.attendance.repository;

import com.ems.attendance.entity.attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface attendanceRepository extends JpaRepository<attendance, Integer> {
    List<attendance> findByEmployeeId(int employee_id);
    List<attendance> findByShiftId(int shift_id);

}
