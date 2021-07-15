package com.example.objectsmapping.services.impl;

import com.example.objectsmapping.dto.EmployeeDto;
import com.example.objectsmapping.dto.ManagerDto;
import com.example.objectsmapping.entities.Employee;
import com.example.objectsmapping.repositories.EmployeeRepository;
import com.example.objectsmapping.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

//    @Override
//    public EmployeeDto findOne(Long id) {
//        //ръчен начин на мапване
//        var employee = this.employeeRepository.findById(id).orElseThrow();
//
//      var dto = new EmployeeDto();
//      dto.setFirstName(employee.getFirstName());
//       dto.setLastName(employee.getLastName());
//       dto.setSalary(employee.getSalary());
//
//        return dto;
//
//        //автоматично (ако са еднакви имената на полетата)
//        ModelMapper mapper = new ModelMapper();
//        return mapper.map(this.employeeRepository.findById(id).orElseThrow() , EmployeeDto.class);
//    }

    @Override
    public ManagerDto findOneMan(Long id) {
        ModelMapper mapper = new ModelMapper();
//        mapper.addMappings(new PropertyMap<Employee, EmployeeDto>() {
//          Така се мапва ако полетата са с различни имена
//            @Override
//            protected void configure() {
//                map().setSalary(source.getSalary()); setПоле (source.getПоле)
//            }
//        });

        return mapper.map(this.employeeRepository.findById(id).orElseThrow(), ManagerDto.class);
    }

    @Override
    public List<ManagerDto> findAllManagers() {
        ModelMapper mapper = new ModelMapper();
        //        mapper.addMappings(new PropertyMap<Employee, EmployeeDto>() {
//          Така се мапва ако полетата са с различни имена
//            @Override
//            protected void configure() {
//                map().setSalary(source.getSalary()); setПоле (source.getПоле)
//            }
//        });
        return mapper.map(this.employeeRepository.findAll() , new TypeToken<List<ManagerDto>>() {}.getType());
    }
}
