package com.example.employeesystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetailsResponse {
    private String empName;
    private String company;
    private String tech;
    private String address;

}
