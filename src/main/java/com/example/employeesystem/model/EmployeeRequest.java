package com.example.employeesystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class EmployeeRequest {
    @NotBlank(message = "Employee name is mandatory")
    @Size(max = 10, message = "Employee name must not exceed 10 characters")
    private String empName;

    @NotBlank(message = "Company name is mandatory")
    @Size(max = 20, message = "Company name must not exceed 20 characters")
    private String company;

    private String tech;

    @NotBlank(message = "Address is mandatory")
    private String address;
}
