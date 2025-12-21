package com.example.demo.service;

import com.example.demo.entity.BranchProfile;

import java.util.List;

public interface BranchProfileService {

    BranchProfile create(BranchProfile branch);
    BranchProfile getById(Long id);
    BranchProfile getByBranchCode(String branchCode);
    List<BranchProfile> getAll();
    BranchProfile updateStatus(Long id, boolean active);
    void delete(Long id);
}
