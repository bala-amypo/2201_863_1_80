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
    public Map<String, String> login(@RequestBody UserAccount user) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                user.getEmail(), user.getPassword()));

        UserAccount dbUser =
                userAccountService.findByEmail(user.getEmail());

        String token =
                jwtUtil.generateToken(
                        dbUser.getEmail(), dbUser.getRole());

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return response;
    }
}
