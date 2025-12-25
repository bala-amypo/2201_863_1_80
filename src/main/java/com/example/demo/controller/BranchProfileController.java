package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.BranchProfile;
import com.example.demo.service.BranchProfileService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/branches")
public class BranchProfileController {

    private final BranchProfileService service;

    public BranchProfileController(BranchProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ApiResponse create(@Valid @RequestBody BranchProfile branch) {
        return new ApiResponse(true, "Branch created successfully",
                service.createBranch(branch));
    }

    @GetMapping
    public ApiResponse getAll() {
        return new ApiResponse(true, "Branches fetched successfully",
                service.getAllBranches());
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Long id) {
        return new ApiResponse(true, "Branch fetched successfully",
                service.getBranchById(id));
    }
}
