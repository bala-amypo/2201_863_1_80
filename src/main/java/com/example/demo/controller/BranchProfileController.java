package com.example.demo.controller;

import com.example.demo.entity.BranchProfile;
import com.example.demo.service.BranchProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchProfileController {

    private final BranchProfileService branchProfileService;

    public BranchProfileController(BranchProfileService branchProfileService) {
        this.branchProfileService = branchProfileService;
    }

    @PostMapping
    public ResponseEntity<BranchProfile> createBranch(@RequestBody BranchProfile branch) {
        BranchProfile createdBranch = branchProfileService.createBranch(branch);
        return ResponseEntity.ok(createdBranch);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<BranchProfile> updateBranchStatus(@PathVariable Long id, @RequestParam boolean active) {
        BranchProfile updatedBranch = branchProfileService.updateBranchStatus(id, active);
        return ResponseEntity.ok(updatedBranch);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchProfile> getBranchById(@PathVariable Long id) {
        BranchProfile branch = branchProfileService.getBranchById(id);
        return ResponseEntity.ok(branch);
    }

    @GetMapping
    public ResponseEntity<List<BranchProfile>> getAllBranches() {
        List<BranchProfile> branches = branchProfileService.getAllBranches();
        return ResponseEntity.ok(branches);
    }

    @GetMapping("/lookup/{branchCode}")
    public ResponseEntity<BranchProfile> findByBranchCode(@PathVariable String branchCode) {
        BranchProfile branch = branchProfileService.findByBranchCode(branchCode);
        return ResponseEntity.ok(branch);
    }
}