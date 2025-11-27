package com.springbootdemo.EMS.service;

import com.springbootdemo.EMS.entity.attendance;

import java.util.List;

public interface attendanceService {
    List<attendance> getAttendanceByEmployeeId(int id);

    List<attendance> getAttendanceByShiftId(int id);

    int markAttendance(attendance attendance);

    attendance editAttendanceByEmployeeId(int id, attendance attendance);

    boolean deleteAttendance(int id);
}
