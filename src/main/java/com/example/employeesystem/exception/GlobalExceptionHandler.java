package com.example.employeesystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundById.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleEmployeeNotFoundById(EmployeeNotFoundById employeeNotFoundById) {
        return new ResponseEntity<>(employeeNotFoundById.getMessage(),HttpStatus.NOT_FOUND);
    }
}
