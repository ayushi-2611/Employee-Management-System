package com.springbootdemo.EMS.service.Impl;

import com.springbootdemo.EMS.entity.employee;
import com.springbootdemo.EMS.repository.employeeRepository;
import com.springbootdemo.EMS.service.employeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class employeeServiceImpl implements employeeService {

    @Autowired
    private employeeRepository employeeRepository;

    @Override
    public List<employee> getEmployees() {
        List<employee> result = employeeRepository.findAll();
        log.info("total employee retrived {}", result.size() );
        log.debug("debug");
        return result;
    }

    @Override
    public employee addEmployee(employee emp) {
        employee result = employeeRepository.save(emp);
        return result;
    }

    @Override
    public employee getEmployeewithId(int id) {
       Optional<employee> result = employeeRepository.findById(id);
       if (result.isEmpty())
       {
           return new employee();
       }
       return result.get();
    }

    @Override
    public boolean deleteEmployee(int id) {
        Optional<employee> result = employeeRepository.findById(id);
        if(result.isEmpty()){
            return false;
        }
        employeeRepository.deleteById(id);
        return true;
    }

    @Override
    public employee updateEmployee(employee emp, int id) {
        Optional<employee> result = employeeRepository.findById(emp.getId());
        AtomicReference<employee> finalResult = new AtomicReference<>(new employee());
        result.map(
                employee -> {
                    employee.setName(emp.getName());
                    employee.setEmail(emp.getEmail());
                    employee.setPhone(emp.getPhone());
                    employee.setRole(emp.getRole());
                    employee.setDepartment((emp.getDepartment()));
                    employee.setSalary(emp.getSalary());
                    return employeeRepository.save(employee);
                }).ifPresent(finalResult::set);

        return finalResult.get();
    }


}
