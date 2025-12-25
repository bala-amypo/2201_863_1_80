package com.example.demo.controller;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class AcademicEventController {

    private final AcademicEventService service;

    public AcademicEventController(AcademicEventService service) {
        this.service = service;
    }

    @PostMapping
    public AcademicEvent create(@RequestBody AcademicEvent event) {
        return service.createEvent(event);
    }

    @GetMapping("/{id}")
    public AcademicEvent getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/branch/{branchId}")
    public List<AcademicEvent> getByBranch(@PathVariable Long branchId) {
        return service.getByBranchId(branchId);
    }
}
