package com.example.employeemanagementsystem.service.serviceImpl;

import com.example.employeemanagementsystem.exception.EmployeeNotFound;
import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import com.example.employeemanagementsystem.response.StatusResponse;
import com.example.employeemanagementsystem.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public StatusResponse<List<Employee>> getAllEmployee() {
        return new StatusResponse<>(200,"Success",repo.findAll(), LocalDateTime.now());
    }

    @Override
    public StatusResponse<Employee> getEmployeeById(int id) {
        if(repo.findById(id).isPresent() == false){
            throw new EmployeeNotFound("No Employee Found by id: "+id);
        }
        return new StatusResponse<>(200, "Success", repo.findById(id).get(), LocalDateTime.now());
    }

    @Override
    public StatusResponse<Employee> insertEmployee(Employee employee) {
        repo.save(employee);
        return new StatusResponse<>(200, "Success", employee, LocalDateTime.now());
    }
}
