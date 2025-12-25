package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.service.UserAccountService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserAccountService service;

    public AuthController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ApiResponse register(
            @Valid @RequestBody RegisterRequest request) {

        service.register(request);
        return new ApiResponse(true, "User registered successfully");
    }

    @PostMapping("/login")
    public ApiResponse login(
            @Valid @RequestBody LoginRequest request) {

        String token = service.login(request);
        return new ApiResponse(true, "Login successful", token);
    }
}
