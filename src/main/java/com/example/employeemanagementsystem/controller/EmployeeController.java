package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.response.StatusResponse;
import com.example.employeemanagementsystem.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @RequestMapping({"","/"})
    public String getMessage(){
        return "Hello from Controller";
    }

    @GetMapping("/employees")
    public StatusResponse<List<Employee>> getAllEmployee(){
        return service.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public StatusResponse<Employee> getEmployeeById(@PathVariable int id){
        return service.getEmployeeById(id);
    }

    @PostMapping("/employees")
    public StatusResponse<Employee> insertEmployee(@RequestBody Employee employee){
        return service.insertEmployee(employee);
    }

}
