package com.example.demo.service.impl;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final EventMergeRecordRepository repo;

    public EventMergeServiceImpl(EventMergeRecordRepository repo) {
        this.repo = repo;
    }

    public EventMergeRecord create(EventMergeRecord record) {
        return repo.save(record);
    }

    public EventMergeRecord getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Merge record not found"));
    }

    public List<EventMergeRecord> getAll() {
        return repo.findAll();
    }

    public List<EventMergeRecord> getByDateRange(LocalDate start, LocalDate end) {
        return repo.findByMergedStartDateBetween(start, end);
    }

    public void delete(Long id) {
        repo.delete(getById(id));
    }
}
