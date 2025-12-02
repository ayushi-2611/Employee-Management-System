package com.ems.attendance.service.impl;


import com.ems.attendance.entity.attendance;
import com.ems.attendance.repository.attendanceRepository;
import com.ems.attendance.service.attendanceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class attendanceServiceImpl implements attendanceService {
    @Autowired
    private attendanceRepository attendanceRepository;

    @Override
    public List<attendance> getAttendanceByEmployeeId(int id) {
        return attendanceRepository.findByEmployeeId(id);
    }

    @Override
    public List<attendance> getAttendanceByShiftId(int id) {
        return attendanceRepository.findByShiftId(id);
    }

    @Override
    public int markAttendance(attendance attendance) {
        attendance result = attendanceRepository.save(attendance);
        if(result == null){
            return 0;
        }
        return 1;
    }

    @Override
    public attendance editAttendanceByEmployeeId(int id, attendance attendance) {
        // Find the existing attendance record by ID
        attendance existingAttendance = (attendance) attendanceRepository.findByEmployeeId(id);
        // Update the fields (set only what you allow to be changed)
//        existingAttendance.setDate(attendance.getDate());
//        existingAttendance.setStatus(attendance.getStatus());
//        existingAttendance.setShift(attendance.getShift());
        BeanUtils.copyProperties(attendance, existingAttendance);
        return attendanceRepository.save(existingAttendance);
    }

    @Override
    public boolean deleteAttendance(int id) {
        Optional<attendance> result = attendanceRepository.findById(id);
        if(result.isEmpty()){
            return false;
        }
        attendanceRepository.deleteById(id);
        return true;
    }

}
