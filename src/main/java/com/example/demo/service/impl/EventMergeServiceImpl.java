package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.repository.EventMergeRepository;
import com.example.demo.service.EventMergeService;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final EventMergeRepository repo;

    public EventMergeServiceImpl(EventMergeRepository repo) {
        this.repo = repo;
    }

    @Override
    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {
        EventMergeRecord record = new EventMergeRecord();
        record.setEventIds(eventIds);
        record.setReason(reason);
        record.setMergeDate(LocalDate.now());
        return repo.save(record);
    }

    @Override
    public EventMergeRecord getMergeRecordById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Merge record not found"));
    }

    @Override
    public List<EventMergeRecord> getAllMergeRecords() {
        return repo.findAll();
    }

    @Override
    public List<EventMergeRecord> getMergeRecordsByDate(LocalDate start, LocalDate end) {
        return repo.findByMergeDateBetween(start, end);
    }
}
