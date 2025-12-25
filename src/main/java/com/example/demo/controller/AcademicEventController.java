package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;

@RestController
@RequestMapping("/api/events")
public class AcademicEventController {

    private final AcademicEventService eventService;

    public AcademicEventController(AcademicEventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public AcademicEvent createEvent(@RequestBody AcademicEvent event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/{id}")
    public AcademicEvent updateEvent(@PathVariable Long id,
                                     @RequestBody AcademicEvent event) {
        return eventService.updateEvent(id, event);
    }

    @GetMapping("/{id}")
    public AcademicEvent getEvent(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @GetMapping("/branch/{branchId}")
    public List<AcademicEvent> getEventsByBranch(
            @PathVariable Long branchId) {
        return eventService.getEventsByBranch(branchId);
    }

    @GetMapping
    public List<AcademicEvent> getAllEvents() {
        return eventService.getAllEvents();
    }
}
