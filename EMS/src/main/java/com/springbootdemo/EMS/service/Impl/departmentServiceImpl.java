package com.springbootdemo.EMS.service.Impl;

import com.springbootdemo.EMS.entity.department;
import com.springbootdemo.EMS.entity.employee;
import com.springbootdemo.EMS.repository.departmentRepository;
import com.springbootdemo.EMS.repository.employeeRepository;
import com.springbootdemo.EMS.service.departmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class departmentServiceImpl implements departmentService {

    @Autowired
    private departmentRepository departmentRepository;
    @Autowired
    private employeeRepository employeeRepository;

    @Override
    public List<department> getDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public department getDepartmentbyId(int id) {
        Optional<department> result = departmentRepository.findById(id);
        if(result.isEmpty()){
            return new department();
        }
        return result.get();
    }

    @Override
    public int addDepartment(department dep) {
        department result = departmentRepository.save(dep);
        if(result == null){
            return -1;
        }
        return result.getId();
    }

    @Override
    public department updateDepartment(department dep, int id) {
        Optional<department> result = departmentRepository.findById(id);
        AtomicReference<department> finalResult = new AtomicReference<>(new department());
        result.map(
                 departmen -> {
                    departmen.setName(dep.getName());
                    departmen.setDescription(dep.getDescription());
                    return departmentRepository.save(departmen);
                }).ifPresent(finalResult::set);
        return finalResult.get();
    }

    @Override
    public boolean deleteDepartment(int id) {
        List<employee> result = employeeRepository.findByDepartmentId(id);
        if(result.isEmpty()){
            return false;
        }
        //departmentRepository.deleteById(id);
        return true;
    }


}
