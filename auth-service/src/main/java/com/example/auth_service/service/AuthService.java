package com.example.auth_service.service;

import org.springframework.stereotype.Service;

import com.example.auth_service.dto.LoginRequest;
import com.example.auth_service.dto.LoginResponse;

@Service
public class AuthService {

    public LoginResponse login(LoginRequest request) {
        if ("admin".equals(request.getUsername()) && "admin123".equals(request.getPassword())) {
            return new LoginResponse("dummy-admin-token", "ADMIN", "Login successful");
        }

        if ("user".equals(request.getUsername()) && "user123".equals(request.getPassword())) {
            return new LoginResponse("dummy-user-token", "USER", "Login successful");
        }

        throw new RuntimeException("Invalid username or password");
    }

    public String validateToken(String token) {
        if ("dummy-admin-token".equals(token)) {
            return "ADMIN";
        }
        if ("dummy-user-token".equals(token)) {
            return "USER";
        }
        throw new RuntimeException("Invalid token");
    }
}