package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userService;

    public AuthController(UserAccountService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public UserAccount login(@RequestBody UserAccount request) {
        return userService.findByEmail(request.getEmail());
    }
}
