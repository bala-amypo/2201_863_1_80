package com.example.demo.service.impl;

import com.example.demo.entity.ClashRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ClashRecordRepository;

public class ClashDetectionServiceImpl {

    private final ClashRecordRepository repository;

    public ClashDetectionServiceImpl(ClashRecordRepository repository) {
        this.repository = repository;
    }

    public ClashRecord save(ClashRecord record) {
        return repository.save(record);
    }

    public ClashRecord resolve(Long id) {
        ClashRecord record = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clash not found"));

        record.setResolved(true);
        return repository.save(record);
    }
}
