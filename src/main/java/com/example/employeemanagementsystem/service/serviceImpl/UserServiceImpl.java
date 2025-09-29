package com.example.employeemanagementsystem.service.serviceImpl;

import com.example.employeemanagementsystem.model.User;
import com.example.employeemanagementsystem.repository.UserRepo;
import com.example.employeemanagementsystem.response.StatusResponse;
import com.example.employeemanagementsystem.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserServiceImpl(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public ResponseEntity<StatusResponse<User>> register(User user) {
        try{
            user.setPassword(encoder.encode(user.getPassword()));
            repo.save(user);
            var response = new StatusResponse<>(200, "Success", user, LocalDateTime.now());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (Exception ex){
            throw new RuntimeException("Failed to register user: " + ex.getMessage());
        }
    }
}
