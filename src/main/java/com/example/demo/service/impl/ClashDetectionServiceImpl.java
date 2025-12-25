package com.example.demo.service.impl;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ClashDetectionServiceImpl implements ClashDetectionService {

    @Override
    public List<ClashRecord> detectClashes(Long branchId) {
        return Collections.emptyList();
    }
}
