package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;

@RestController
@RequestMapping("/api/merge-records")
public class EventMergeController {

    private final EventMergeService service;

    public EventMergeController(EventMergeService service) {
        this.service = service;
    }

    @PostMapping
    public EventMergeRecord merge(@RequestBody EventMergeRecord record) {
        return service.mergeEvents(
                record.getEventIds(),
                record.getReason()
        );
    }

    @GetMapping("/{id}")
    public EventMergeRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<EventMergeRecord> getAll() {
        return service.getAll();
    }
}
