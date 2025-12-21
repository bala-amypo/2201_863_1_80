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

    public ClashRecord logClash(ClashRecord clash) {
        return repo.save(clash);
    }

    public ClashRecord resolveClash(Long id) {
        ClashRecord clash = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clash not found"));
        clash.setResolved(true);
        return repo.save(clash);
    }

    public List<ClashRecord> getClashesForEvent(Long eventId) {
        return repo.findByEventAIdOrEventBId(eventId, eventId);
    }

    public List<ClashRecord> getUnresolvedClashes() {
        return repo.findByResolvedFalse();
    }

    public List<ClashRecord> getAllClashes() {
        return repo.findAll();
    }
}
