package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.model.User;
import com.example.employeemanagementsystem.response.StatusResponse;
import com.example.employeemanagementsystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<StatusResponse<User>> register(@RequestBody User user){
        return service.register(user);
    }

}
