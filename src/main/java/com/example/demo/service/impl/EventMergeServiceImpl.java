package com.example.demo.service.impl;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final EventMergeRecordRepository repository;

    public EventMergeServiceImpl(EventMergeRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {

        if (eventIds == null || eventIds.size() < 2) {
            throw new ValidationException("At least two events required");
        }

        EventMergeRecord record = new EventMergeRecord();
        record.setEventAId(eventIds.get(0));
        record.setEventBId(eventIds.get(1));
        record.setReason(reason);

        return repository.save(record);
    }

    @Override
    public List<EventMergeRecord> getMergeHistory() {
        return repository.findAll();
    }
}
