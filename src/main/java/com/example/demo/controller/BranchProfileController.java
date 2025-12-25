package com.example.demo.controller;

import com.example.demo.entity.BranchProfile;
import com.example.demo.service.BranchProfileService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchProfileController {

    private final BranchProfileService service;

    public BranchProfileController(BranchProfileService service) {
        this.service = service;
    }

    @PostMapping
    public BranchProfile createBranch(
            @Valid @RequestBody BranchProfile branch) {
        return service.createBranch(branch);
    }

    @GetMapping("/{id}")
    public BranchProfile getBranch(@PathVariable Long id) {
        return service.getBranchById(id);
    }

    @GetMapping
    public List<BranchProfile> getAllBranches() {
        return service.getAllBranches();
    }
}
