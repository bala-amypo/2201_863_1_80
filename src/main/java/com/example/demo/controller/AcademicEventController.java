package com.example.demo.controller;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class AcademicEventController {

    private final AcademicEventService academicEventService;

    public AcademicEventController(AcademicEventService academicEventService) {
        this.academicEventService = academicEventService;
    }

    @PostMapping
    public AcademicEvent createEvent(@RequestBody AcademicEvent event) {
        return academicEventService.createEvent(event);
    }

    @PutMapping("/{id}")
    public AcademicEvent updateEvent(
            @PathVariable Long id,
            @RequestBody AcademicEvent event) {
        return academicEventService.updateEvent(id, event);
    }

    @GetMapping
    public List<AcademicEvent> getAllEvents() {
        return academicEventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public AcademicEvent getEventById(@PathVariable Long id) {
        return academicEventService.getEventById(id);
    }

    @GetMapping("/branch/{branchId}")
    public List<AcademicEvent> getEventsByBranch(
            @PathVariable Long branchId) {
        return academicEventService.getEventsByBranch(branchId);
    }
}
