package com.example.employeesystem.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class EmployeeServiceAspect {

    @Before("execution(* com.example.employeesystem.service.EmployeeService.getEmployeeById(..))")
    public void beforeGetMethod() {
        log.info("Before get method");

    }
}
