package com.example.employeemanagementsystem.exception;

public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound(String msg){
        super(msg);
    }
}
