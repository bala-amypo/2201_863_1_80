package com.example.demo.controller;

import com.example.demo.entity.BranchProfile;
import com.example.demo.service.BranchProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/branches")
public class BranchProfileController {

    private final BranchProfileService service;

    public BranchProfileController(BranchProfileService service) {
        this.service = service;
    }

    @PostMapping
    public BranchProfile save(@RequestBody BranchProfile branch) {
        return service.save(branch);
    }

    @GetMapping("/{id}")
    public BranchProfile get(@PathVariable Long id) {
        return service.getById(id);
    }
}
