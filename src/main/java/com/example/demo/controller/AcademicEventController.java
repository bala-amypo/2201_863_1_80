package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;

@RestController
@RequestMapping("/api/events")
public class AcademicEventController {

    private final AcademicEventService academicEventService;

    public AcademicEventController(AcademicEventService academicEventService) {
        this.academicEventService = academicEventService;
    }

   
    @PostMapping
    public ResponseEntity<AcademicEvent> createEvent(@RequestBody AcademicEvent event) {
        return ResponseEntity.ok(academicEventService.createEvent(event));
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<AcademicEvent> updateEvent(
            @PathVariable Long id,
            @RequestBody AcademicEvent event) {
        return ResponseEntity.ok(academicEventService.updateEvent(id, event));
    }

    
    @GetMapping("/branch/{branchId}")
    public ResponseEntity<List<AcademicEvent>> getByBranch(@PathVariable Long branchId) {
        return ResponseEntity.ok(academicEventService.getEventsByBranch(branchId));
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<AcademicEvent> getById(@PathVariable Long id) {
        return ResponseEntity.ok(academicEventService.getEventById(id));
    }

    
    @GetMapping
    public ResponseEntity<List<AcademicEvent>> getAll() {
        return ResponseEntity.ok(academicEventService.getAllEvents());
    }
}
