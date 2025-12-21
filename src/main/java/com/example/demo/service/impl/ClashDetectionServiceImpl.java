package com.example.demo.service.impl;

import com.example.demo.entity.ClashRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ClashRecordRepository;
import com.example.demo.service.ClashDetectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClashDetectionServiceImpl implements ClashDetectionService {

    private final ClashRecordRepository repo;

    public ClashDetectionServiceImpl(ClashRecordRepository repo) {
        this.repo = repo;
    }

    public ClashRecord create(ClashRecord clash) {
        return repo.save(clash);
    }

    public ClashRecord resolve(Long id) {
        ClashRecord clash = getById(id);
        clash.setResolved(true);
        return repo.save(clash);
    }

    public ClashRecord getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clash not found"));
    }

    public List<ClashRecord> getAll() {
        return repo.findAll();
    }

    public List<ClashRecord> getUnresolved() {
        return repo.findByResolvedFalse();
    }
}
