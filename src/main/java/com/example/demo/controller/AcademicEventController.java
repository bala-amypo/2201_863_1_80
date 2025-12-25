package com.example.demo.controller;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class AcademicEventController {

    private final AcademicEventService service;

    public AcademicEventController(AcademicEventService service) {
        this.service = service;
    }

    @PostMapping
    public AcademicEvent createEvent(
            @Valid @RequestBody AcademicEvent event) {
        return service.createEvent(event);
    }

    @PutMapping("/{id}")
    public AcademicEvent updateEvent(
            @PathVariable Long id,
            @Valid @RequestBody AcademicEvent event) {
        return service.updateEvent(id, event);
    }

    @GetMapping("/{id}")
    public AcademicEvent getEvent(@PathVariable Long id) {
        return service.getEventById(id);
    }

    @GetMapping
    public List<AcademicEvent> getAllEvents() {
        return service.getAllEvents();
    }

    @GetMapping("/branch/{branchId}")
    public List<AcademicEvent> getByBranch(
            @PathVariable Long branchId) {
        return service.getEventsByBranch(branchId);
    }
}
