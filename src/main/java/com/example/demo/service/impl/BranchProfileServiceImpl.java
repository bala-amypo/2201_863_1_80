package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BranchProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BranchProfileRepository;
import com.example.demo.service.BranchProfileService;

@Service
public class BranchProfileServiceImpl implements BranchProfileService {

    private final BranchProfileRepository branchRepo;

    public BranchProfileServiceImpl(BranchProfileRepository branchRepo) {
        this.branchRepo = branchRepo;
    }

    @Override
    public BranchProfile createBranch(BranchProfile branch) {
        return branchRepo.save(branch);
    }

    @Override
    public BranchProfile updateBranchStatus(Long id, boolean active) {
        BranchProfile branch = branchRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Branch not found"));
        branch.setActive(active);
        return branchRepo.save(branch);
    }

    @Override
    public List<BranchProfile> getAllBranches() {
        return branchRepo.findAll();
    }

    @Override
    public BranchProfile getBranchById(Long id) {
        return branchRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Branch not found"));
    }

    @Override
    public BranchProfile findByBranchCode(String branchCode) {
        return branchRepo.findByBranchCode(branchCode)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Branch not found"));
    }
}
