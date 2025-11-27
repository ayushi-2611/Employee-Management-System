package com.springbootdemo.EMS.service.Impl;

import com.springbootdemo.EMS.entity.attendance;
import com.springbootdemo.EMS.repository.attendanceRepository;
import com.springbootdemo.EMS.service.attendanceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class attendanceServiceImpl implements attendanceService {
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
        existingAttendance.setDate(attendance.getDate());
        existingAttendance.setStatus(attendance.getStatus());
        existingAttendance.setShift(attendance.getShift());
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
