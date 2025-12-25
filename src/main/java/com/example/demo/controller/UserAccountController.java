package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService userService;

    public UserAccountController(UserAccountService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserAccount> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserAccount getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
}
