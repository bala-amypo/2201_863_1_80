package com.example.demo.controller;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/merges")
public class EventMergeController {

    private final EventMergeService eventMergeService;

    public EventMergeController(EventMergeService eventMergeService) {
        this.eventMergeService = eventMergeService;
    }

    @PostMapping
    public ResponseEntity<EventMergeRecord> mergeEvents(@RequestBody Map<String, Object> request) {
        List<Long> eventIds = (List<Long>) request.get("eventIds");
        String reason = (String) request.get("reason");
        EventMergeRecord mergeRecord = eventMergeService.mergeEvents(eventIds, reason);
        return ResponseEntity.ok(mergeRecord);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventMergeRecord> getMergeRecordById(@PathVariable Long id) {
        EventMergeRecord mergeRecord = eventMergeService.getMergeRecordById(id);
        return ResponseEntity.ok(mergeRecord);
    }

    @GetMapping
    public ResponseEntity<List<EventMergeRecord>> getAllMergeRecords() {
        List<EventMergeRecord> mergeRecords = eventMergeService.getAllMergeRecords();
        return ResponseEntity.ok(mergeRecords);
    }

    @GetMapping("/range")
    public ResponseEntity<List<EventMergeRecord>> getMergeRecordsByDate(@RequestParam LocalDate start, @RequestParam LocalDate end) {
        List<EventMergeRecord> mergeRecords = eventMergeService.getMergeRecordsByDate(start, end);
        return ResponseEntity.ok(mergeRecords);
    }
}