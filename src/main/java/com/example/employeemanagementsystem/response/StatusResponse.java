package com.example.employeemanagementsystem.response;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record StatusResponse<T>(
        int status,
        String message,
        T data,
        LocalDateTime time
) {
}
