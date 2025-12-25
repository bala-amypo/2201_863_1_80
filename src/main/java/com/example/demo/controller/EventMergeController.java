package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;

@RestController
@RequestMapping("/api/merge-records")
public class EventMergeController {

    private final EventMergeService mergeService;

    public EventMergeController(EventMergeService mergeService) {
        this.mergeService = mergeService;
    }

    @PostMapping
    public EventMergeRecord mergeEvents(
            @RequestParam List<Long> eventIds,
            @RequestParam String reason) {
        return mergeService.mergeEvents(eventIds, reason);
    }

    @GetMapping
    public List<EventMergeRecord> getAllMerges() {
        return mergeService.getAllMergeRecords();
    }

    @GetMapping("/{id}")
    public EventMergeRecord getMergeById(@PathVariable Long id) {
        return mergeService.getMergeRecordById(id);
    }
}
