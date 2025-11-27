package com.springbootdemo.EMS.service.Impl;

import com.springbootdemo.EMS.entity.shift;
import com.springbootdemo.EMS.repository.shiftRepository;
import com.springbootdemo.EMS.service.shiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class shiftServiceImpl implements shiftService {

    @Autowired
    private shiftRepository shiftRepository;

    @Override
    public List<shift> getShift() {
        return shiftRepository.findAll();
    }

    @Override
    public int addShift(shift shift) {
        shift result = shiftRepository.save(shift);
        if(result==null){
            return 0;
        }
        return 1;
    }

    @Override
    public boolean deleteShift(int id) {
        Optional<shift> result = shiftRepository.findById(id);
        if(result.isEmpty()){
            return false;
        }
        shiftRepository.deleteById(id);
        return true;
    }

}
