package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;

@RestController
@RequestMapping("/api/merge-records")
public class EventMergeController {

    private final EventMergeService eventMergeService;

    public EventMergeController(EventMergeService eventMergeService) {
        this.eventMergeService = eventMergeService;
    }

  
    @PostMapping
    public ResponseEntity<EventMergeRecord> merge(@RequestBody EventMergeRecord record) {
        return ResponseEntity.ok(eventMergeService.mergeEvents(record));
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<EventMergeRecord> getById(@PathVariable Long id) {
        return ResponseEntity.ok(eventMergeService.getMergeRecordById(id));
    }

   
    @GetMapping
    public ResponseEntity<List<EventMergeRecord>> getAll() {
        return ResponseEntity.ok(eventMergeService.getAllMergeRecords());
    }

    
    @GetMapping("/range")
    public ResponseEntity<List<EventMergeRecord>> getByRange(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return ResponseEntity.ok(eventMergeService.getMergeRecordsByDate(start, end));
    }
}
