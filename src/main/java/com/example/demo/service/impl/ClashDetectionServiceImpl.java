package com.example.demo.service.impl;

import com.example.demo.entity.ClashRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ClashRecordRepository;
import com.example.demo.service.ClashDetectionService;
import org.springframework.stereotype.Service;

@Service
public class ClashDetectionServiceImpl implements ClashDetectionService {

    private final ClashRecordRepository repository;

    public ClashDetectionServiceImpl(ClashRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClashRecord save(ClashRecord record) {
        return repository.save(record);
    }

    @Override
    public ClashRecord resolve(Long id) {
        ClashRecord record = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clash not found"));

        record.setResolved(true);
        return repository.save(record);
    }
}
