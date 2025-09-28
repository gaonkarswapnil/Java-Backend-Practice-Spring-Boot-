package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.response.StatusResponse;
import com.example.employeemanagementsystem.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @RequestMapping({"","/"})
    public String getMessage(HttpServletRequest request){
        return "Hello from Controller"+request.getSession().getId();
    }

    @GetMapping("/employees")
    public ResponseEntity<StatusResponse<List<Employee>>> getAllEmployee(){
        return service.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<StatusResponse<Employee>> getEmployeeById(@PathVariable int id){
        return service.getEmployeeById(id);
    }

    @PostMapping("/employees")
    public ResponseEntity<StatusResponse<Employee>> insertEmployee(@RequestBody Employee employee){
        return service.insertEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<StatusResponse<Employee>> updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        return service.updateEmployee(id, employee);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<StatusResponse<String>> deleteEmployee(@PathVariable int id){
        return service.deleteEmployee(id);
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
