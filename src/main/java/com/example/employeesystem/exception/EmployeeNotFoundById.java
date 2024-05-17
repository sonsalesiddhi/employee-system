package com.example.employeesystem.exception;

public class EmployeeNotFoundById extends RuntimeException{
    public EmployeeNotFoundById(String message) {
        super(message);
    }
}

