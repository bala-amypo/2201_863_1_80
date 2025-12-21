package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final EventMergeRecordRepository repo;

    public EventMergeServiceImpl(EventMergeRecordRepository repo) {
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
    public EventMergeRecord getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public List<EventMergeRecord> getAll() {
        return repo.findAll();
    }
}
