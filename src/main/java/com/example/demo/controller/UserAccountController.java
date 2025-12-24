package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class UserAccountController {

    private final UserAccountService userAccountService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public UserAccountController(UserAccountService userAccountService,
                                 JwtUtil jwtUtil,
                                 PasswordEncoder passwordEncoder) {
        this.userAccountService = userAccountService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    // =========================
    // REGISTER
    // =========================
    @PostMapping("/register")
    public ApiResponse register(@RequestBody RegisterRequest request) {

        UserAccount user = new UserAccount();
        user.setFullName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        user.setDepartment(request.getDepartment());

        return new ApiResponse(
                true,
                "User registered",
                userAccountService.register(user)
        );
    }

    // =========================
    // LOGIN
    // =========================
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

        return new ApiResponse(
                true,
                "Login successful",
                Map.of(
                        "token", token,
                        "user", user
                )
        );
    }

    // =========================
    // GET ALL USERS (ADMIN)
    // =========================
    @GetMapping("/users")
    public ApiResponse getAllUsers() {
        return new ApiResponse(
                true,
                "Users fetched",
                userAccountService.getAllUsers()
        );
    }

    // =========================
    // GET USER BY ID (ADMIN)
    // =========================
    @GetMapping("/users/{id}")
    public ApiResponse getUser(@PathVariable Long id) {
        return new ApiResponse(
                true,
                "User fetched",
                userAccountService.getUser(id)
        );
    }
}
