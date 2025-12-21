package com.example.demo.service.impl;

import com.example.demo.entity.BranchProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BranchProfileRepository;
import com.example.demo.service.BranchProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchProfileServiceImpl implements BranchProfileService {

    private final BranchProfileRepository repo;

    public BranchProfileServiceImpl(BranchProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public BranchProfile create(BranchProfile branch) {
        return repo.save(branch);
    }

    @Override
    public BranchProfile getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found"));
    }

    @Override
    public BranchProfile getByBranchCode(String branchCode) {
        return repo.findByBranchCode(branchCode)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found"));
    }

    @Override
    public List<BranchProfile> getAll() {
        return repo.findAll();
    }

    @Override
    public BranchProfile updateStatus(Long id, boolean active) {
        BranchProfile branch = getById(id);
        branch.setActive(active);
        return repo.save(branch);
    }

    @Override
    public void delete(Long id) {
        repo.delete(getById(id));
    }
}
