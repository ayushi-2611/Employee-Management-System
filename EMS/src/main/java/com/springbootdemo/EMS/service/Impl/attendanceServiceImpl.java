package com.springbootdemo.EMS.service.Impl;

import com.springbootdemo.EMS.entity.attendance;
import com.springbootdemo.EMS.service.attendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class attendanceServiceImpl implements attendanceService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<attendance> getAttendanceByEmployeeId(int id) {
        String url = "http://localhost:8085/ams/attendance/EmployeeId/";
        ArrayList<attendance> saveVariable = restTemplate.getForObject(url + id, ArrayList.class);
        return saveVariable;
    }

    @Override
    public List<attendance> getAttendanceByShiftId(int id) {
        String url = "http://localhost:8085/ams/attendance/shift/";
        return restTemplate.getForObject(url + id, ArrayList.class);
    }

    @Override
    public int markAttendance(attendance attendance) {
        String url = "http://localhost:8085/ams/attendance/add";
        ResponseEntity<Integer> response =
                restTemplate.postForEntity(url, attendance, Integer.class);

        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
            return 0;
        }
        return response.getBody();
    }

    @Override
    public attendance editAttendanceByEmployeeId(int id, attendance attendance) {
        String url = "http://localhost:8085/ams/attendance/editAttendanceByEmployeeId/" + id;

        HttpEntity<attendance> requestEntity = new HttpEntity<>(attendance);

        ResponseEntity<attendance> response = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                requestEntity,
                attendance.class
        );

        // Handle null / non-2xx if you want more robustness
        return response.getBody();
    }

    @Override
    public boolean deleteAttendance(int id) {
        String url = "http://localhost:8085/ams/attendance/deleteAttendance/" + id;

        ResponseEntity<Boolean> response = restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                null,
                Boolean.class
        );

        return response.getBody() != null && response.getBody();
    }
}

