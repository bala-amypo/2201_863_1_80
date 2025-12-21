package com.example.demo.controller;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/merge-records")
@Tag(name = "Event Merge Records")
public class EventMergeController {

    private final EventMergeService service;

    public EventMergeController(EventMergeService service) {
        this.service = service;
    }

    @PostMapping
    public EventMergeRecord create(@RequestBody EventMergeRecord record) {
        return service.create(record);
    }

    @GetMapping("/{id}")
    public EventMergeRecord get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<EventMergeRecord> getAll() {
        return service.getAll();
    }

    @GetMapping("/range")
    public List<EventMergeRecord> getByRange(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return service.getByDateRange(start, end);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
