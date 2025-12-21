package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EventMergeRecord;

public interface EventMergeService {

    EventMergeRecord mergeEvents(List<Long> eventIds, String reason);

    EventMergeRecord getById(Long id);

    List<EventMergeRecord> getAll();
}
