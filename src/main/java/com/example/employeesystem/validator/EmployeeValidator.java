package com.example.employeesystem.validator;

import com.example.employeesystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator {

   private final EmployeeRepository employeeRepository;

   @Autowired
    public EmployeeValidator(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public boolean doesEmployeeExist(int id) {
       return employeeRepository.existsById(id);

    }
}
