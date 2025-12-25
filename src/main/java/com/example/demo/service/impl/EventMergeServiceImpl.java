package com.example.demo.service.impl;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.repository.EventMergeRecordRepository;

public class EventMergeServiceImpl {

    private final EventMergeRecordRepository repository;

    public EventMergeServiceImpl(EventMergeRecordRepository repository) {
        this.repository = repository;
    }

    public EventMergeRecord merge(EventMergeRecord record) {
        return repository.save(record);
    }
}
