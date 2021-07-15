package com.example.objectsmapping;

import com.example.objectsmapping.dto.ManagerDto;
import com.example.objectsmapping.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {

    private final EmployeeService employeeService;

    public Main(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        ManagerDto dto = this.employeeService.findOneMan(1L);
        System.out.println(dto.getFirstName() + " " + dto.getLastName() + ": ");
        dto.getSubordinates().forEach(employeeDto -> {
            System.out.println("\t " + employeeDto.getFirstName() + " " + employeeDto.getLastName() + " " + employeeDto.getSalary());
        });
    }
}
