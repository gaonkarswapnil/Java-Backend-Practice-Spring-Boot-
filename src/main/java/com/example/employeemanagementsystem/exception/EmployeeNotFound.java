package com.example.employeemanagementsystem.exception;

import org.springframework.stereotype.Component;

@Component
public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound(String msg){
        super(msg);
    }
}
