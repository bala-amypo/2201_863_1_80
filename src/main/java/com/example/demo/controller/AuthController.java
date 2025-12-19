package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserAccountService userAccountService;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil,
                          UserAccountService userAccountService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userAccountService = userAccountService;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return userAccountService.register(user);
    }

    @PostMapping("/login")
public ApiResponse login(@RequestBody LoginRequest request) {

    UserAccount user = userAccountService.findByEmail(request.getEmail());

    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
        return new ApiResponse(false, "Invalid credentials");
    }

    String token = jwtUtil.generateToken(
            user.getId(),
            user.getEmail(),
            user.getRole()
    );

    return new ApiResponse(true, "Login successful", token);
}
