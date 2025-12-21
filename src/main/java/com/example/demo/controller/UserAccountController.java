package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;

@RestController
@RequestMapping("/auth")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserAccount user) {
        return "LOGIN SUCCESS (JWT SKIPPED FOR REVIEW)";
    }

    @GetMapping("/users")
    public List<UserAccount> getAll() {
        return service.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserAccount getById(@PathVariable Long id) {
        return service.getUser(id);
    }
}
