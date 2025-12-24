package com.example.demo.controller;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/merge-records")
public class EventMergeController {

    private final EventMergeService eventMergeService;

    public EventMergeController(EventMergeService eventMergeService) {
        this.eventMergeService = eventMergeService;
    }

    @PostMapping
    public EventMergeRecord mergeEvents(@RequestParam List<Long> eventIds,
                                        @RequestParam String reason) {
        return eventMergeService.mergeEvents(eventIds, reason);
    }

    @GetMapping("/{id}")
    public EventMergeRecord getById(@PathVariable Long id) {
        return eventMergeService.getMergeRecordById(id);
    }

    @GetMapping
    public List<EventMergeRecord> getAll() {
        return eventMergeService.getAllMergeRecords();
    }

    @GetMapping("/range")
    public List<EventMergeRecord> getByRange(@RequestParam LocalDate start,
                                             @RequestParam LocalDate end) {
        return eventMergeService.getMergeRecordsByDate(start, end);
    }
}
