package com.example.employeesystem.controller;

import com.example.employeesystem.model.EmployeeDetailsResponse;
import com.example.employeesystem.model.EmployeeRequest;
import com.example.employeesystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    public String createEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        return employeeService.createEmployee(employeeRequest);
    }


    @GetMapping("/employee/{empId}")
    public EmployeeDetailsResponse getEmployeeById(@PathVariable int empId) {
        EmployeeDetailsResponse employeeDetailsResponse = employeeService.getEmployeeById(empId);
        return employeeDetailsResponse;
    }

    @PutMapping("/employee/{empId}")
    public EmployeeDetailsResponse updateEmployee(@RequestBody EmployeeRequest employeeRequest, @PathVariable int empId) {
       return employeeService.updateEmployee(employeeRequest, empId);

    }

    @DeleteMapping("/employee/{empId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int empId) {
        return new ResponseEntity<>(employeeService.deleteEmployee(empId), HttpStatus.ACCEPTED);
    }

}
