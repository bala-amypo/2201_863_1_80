package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ClashRecord;
import com.example.demo.repository.ClashRecordRepository;
import com.example.demo.service.ClashRecordService;

@Service
public class ClashRecordServiceImpl implements ClashRecordService {

    private final ClashRecordRepository clashRecordRepository;

    public ClashRecordServiceImpl(ClashRecordRepository clashRecordRepository) {
        this.clashRecordRepository = clashRecordRepository;
    }

    @Override
    public List<ClashRecord> getClashesByBranch(Long branchId) {
        return clashRecordRepository.findByBranchId(branchId);
    }
}
