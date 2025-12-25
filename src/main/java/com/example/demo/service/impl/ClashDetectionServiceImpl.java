package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ClashRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ClashRecordRepository;
import com.example.demo.service.ClashDetectionService;

@Service
public class ClashDetectionServiceImpl implements ClashDetectionService {

    private final ClashRecordRepository clashRepo;

    public ClashDetectionServiceImpl(ClashRecordRepository clashRepo) {
        this.clashRepo = clashRepo;
    }

    @Override
    public ClashRecord logClash(ClashRecord clash) {
        return clashRepo.save(clash);
    }

    @Override
    public List<ClashRecord> getClashesForEvent(Long eventId) {
        return clashRepo.findByEventAIdOrEventBId(eventId, eventId);
    }

    @Override
    public ClashRecord resolveClash(Long clashId) {
        ClashRecord clash = clashRepo.findById(clashId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Clash not found"));
        clash.setResolved(true);
        return clashRepo.save(clash);
    }

    @Override
    public List<ClashRecord> getUnresolvedClashes() {
        return clashRepo.findByResolvedFalse();
    }

    @Override
    public List<ClashRecord> getAllClashes() {
        return clashRepo.findAll();
    }
}
