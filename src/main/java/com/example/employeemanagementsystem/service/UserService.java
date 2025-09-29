package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.model.User;
import com.example.employeemanagementsystem.response.StatusResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<StatusResponse<User>> register(User user);
}
