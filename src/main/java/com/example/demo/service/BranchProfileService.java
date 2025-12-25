package com.example.demo.service;

import com.example.demo.entity.BranchProfile;

public interface BranchProfileService {

    BranchProfile save(BranchProfile branch);

    BranchProfile getById(Long id);
}
