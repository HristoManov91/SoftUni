package com.example.objectsmapping.services;

import com.example.objectsmapping.dto.EmployeeDto;
import com.example.objectsmapping.dto.ManagerDto;

import java.util.List;

public interface EmployeeService {

//    EmployeeDto findOne(Long id);

    ManagerDto findOneMan(Long id);

    List<ManagerDto> findAllManagers();
}
