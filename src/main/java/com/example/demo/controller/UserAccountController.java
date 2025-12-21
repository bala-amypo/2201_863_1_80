package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Accounts")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping
    public UserAccount create(@RequestBody UserAccount user) {
        return service.create(user);
    }

    @GetMapping("/{id}")
    public UserAccount get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<UserAccount> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public UserAccount update(@PathVariable Long id, @RequestBody UserAccount user) {
        return service.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
