package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.response.StatusResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    ResponseEntity<StatusResponse<List<Employee>>> getAllEmployee();

    ResponseEntity<StatusResponse<Employee>> getEmployeeById(int id);

    ResponseEntity<StatusResponse<Employee>> insertEmployee(Employee employee);

    ResponseEntity<StatusResponse<Employee>> updateEmployee(int id,  Employee employee);

    ResponseEntity<StatusResponse<String>> deleteEmployee(int id);
}
