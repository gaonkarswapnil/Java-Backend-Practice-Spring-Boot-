package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.response.StatusResponse;

import java.util.List;

public interface EmployeeService {

    StatusResponse<List<Employee>> getAllEmployee();

    StatusResponse<Employee> getEmployeeById(int id);

    StatusResponse<Employee> insertEmployee(Employee employee);

}
