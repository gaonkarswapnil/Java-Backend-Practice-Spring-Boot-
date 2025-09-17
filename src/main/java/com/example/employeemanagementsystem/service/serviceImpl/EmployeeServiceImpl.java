package com.example.employeemanagementsystem.service.serviceImpl;

import com.example.employeemanagementsystem.exception.EmployeeNotFound;
import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import com.example.employeemanagementsystem.response.StatusResponse;
import com.example.employeemanagementsystem.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public ResponseEntity<StatusResponse<List<Employee>>> getAllEmployee() {
        var response = new StatusResponse<>(200,"Success",repo.findAll(), LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StatusResponse<Employee>> getEmployeeById(int id) {
        Optional<Employee> employeeOpt = repo.findById(id);
        if (employeeOpt.isEmpty()){
            throw new EmployeeNotFound("No Employee Found by ID:"+id);
        }
        var response = new StatusResponse<>(200,"Success", employeeOpt.get(), LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StatusResponse<Employee>> insertEmployee(Employee employee) {
        try{
            repo.save(employee);
            var response = new StatusResponse<>(200, "Success", employee, LocalDateTime.now());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (Exception ex){
            throw new RuntimeException("Failed to create employee: " + ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<StatusResponse<Employee>> updateEmployee(int id, Employee employee) {
        Optional<Employee> employeeOpt = repo.findById(id);
        if(employeeOpt.isEmpty()){
            throw new EmployeeNotFound("No Employee Found by ID:"+id);
        }
        Employee emp = employeeOpt.get();
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        emp.setDepartment(employee.getDepartment());
        emp.setSalary(employee.getSalary());

        repo.save(emp);
        var response = new StatusResponse<>(
                200,
                "Success",
                emp,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<StatusResponse<String>> deleteEmployee(int id) {
        Optional<Employee> employeeOpt = repo.findById(id);
        if(employeeOpt.isEmpty()){
            throw new EmployeeNotFound("No Employee Found by ID:"+id);
        }
        repo.delete(employeeOpt.get());
        var response = new StatusResponse<>(
                200,
                "Success",
                "Employee with Id: "+id+" is deleted",
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
