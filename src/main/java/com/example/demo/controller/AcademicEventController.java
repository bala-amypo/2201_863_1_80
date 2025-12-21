package com.example.demo.controller;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@Tag(name = "Academic Events")
public class AcademicEventController {

    private final AcademicEventService service;

    public AcademicEventController(AcademicEventService service) {
        this.service = service;
    }

    @PostMapping
    public AcademicEvent create(@RequestBody AcademicEvent event) {
        return service.createEvent(event);
    }

    @PutMapping("/{id}")
    public AcademicEvent update(@PathVariable Long id, @RequestBody AcademicEvent event) {
        return service.updateEvent(id, event);
    }

    @GetMapping("/{id}")
    public AcademicEvent get(@PathVariable Long id) {
        return service.getEventById(id);
    }

    @GetMapping("/branch/{branchId}")
    public List<AcademicEvent> byBranch(@PathVariable Long branchId) {
        return service.getEventsByBranch(branchId);
    }

    @GetMapping
    public List<AcademicEvent> all() {
        return service.getAllEvents();
    }
}
