package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
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
    public ApiResponse create(@Valid @RequestBody AcademicEvent event) {
        return new ApiResponse(true, "Event created successfully",
                service.createEvent(event));
    }

    @PutMapping("/{id}")
    public ApiResponse update(@PathVariable Long id,
                              @Valid @RequestBody AcademicEvent event) {
        return new ApiResponse(true, "Event updated successfully",
                service.updateEvent(id, event));
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Long id) {
        return new ApiResponse(true, "Event fetched successfully",
                service.getEventById(id));
    }

    @GetMapping
    public ApiResponse getAll() {
        return new ApiResponse(true, "Events fetched successfully",
                service.getAllEvents());
    }

    @GetMapping("/branch/{branchId}")
    public ApiResponse getByBranch(@PathVariable Long branchId) {
        return new ApiResponse(true, "Branch events fetched successfully",
                service.getEventsByBranch(branchId));
    }
}
