package com.example.employeesystem.service;

import com.example.employeesystem.entity.Employee;
import com.example.employeesystem.entity.EmployeeAddress;
import com.example.employeesystem.exception.EmployeeNotFoundById;
import com.example.employeesystem.model.EmployeeDetailsResponse;
import com.example.employeesystem.model.EmployeeRequest;
import com.example.employeesystem.repository.EmployeeRepository;
import com.example.employeesystem.validator.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeValidator employeeValidator;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeValidator employeeValidator) {
        this.employeeRepository = employeeRepository;
        this.employeeValidator = employeeValidator;
    }

    public EmployeeDetailsResponse getEmployeeById(int empId) {
        if(employeeValidator.doesEmployeeExist(empId)) {

            Employee employee = employeeRepository.findById(empId).get();

            EmployeeDetailsResponse employeeDetailsResponse = EmployeeDetailsResponse.builder()
                    .empName(employee.getEmpName())
                    .company(employee.getCompany())
                    .tech(employee.getTech())
                    .address(employee.getEmployeeAddress().getAddress())
                    .build();
            return employeeDetailsResponse;
        }
        else
            throw new EmployeeNotFoundById("Employee with id"+empId+"not found");

    }

    public String createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder()
                .empName(employeeRequest.getEmpName())
                .company(employeeRequest.getCompany())
                .tech(employeeRequest.getTech())
                .employeeAddress(EmployeeAddress.builder().address(employeeRequest.getAddress()).build())
                .build();

        employeeRepository.save(employee);
        return "employee created successfully";


    }

    public EmployeeDetailsResponse updateEmployee(EmployeeRequest employeeRequest, int empId) {
        if(employeeValidator.doesEmployeeExist(empId)) {
            Employee employee1 = employeeRepository.findById(empId).get();


            Employee employee = Employee.builder()
                    .empid(empId)
                    .empName(employeeRequest.getEmpName())
                    .company(employeeRequest.getCompany())
                    .tech(employeeRequest.getTech())
                    .employeeAddress(EmployeeAddress.builder().address(employeeRequest.getAddress()).addressId(employee1.getEmployeeAddress().getAddressId()).build())
                    .build();
            Employee saveEmployee = employeeRepository.save(employee);

            EmployeeDetailsResponse employeeDetailsResponse = EmployeeDetailsResponse.builder()
                    .empName(saveEmployee.getEmpName())
                    .company(saveEmployee.getCompany())
                    .tech(saveEmployee.getTech())
                    .address(saveEmployee.getEmployeeAddress().getAddress())
                    .build();
            return employeeDetailsResponse;
        }
        else
            throw new EmployeeNotFoundById("Employee with id"+empId+"not found");
    }

    public String deleteEmployee(int empId) {
        if (employeeValidator.doesEmployeeExist(empId)) {
            employeeRepository.deleteById(empId);
            return "employee deleted successfully";
        }
        else
            throw new EmployeeNotFoundById("Employee with id"+empId+"not found");
    }
}
