package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class AcademicEventController {

    private final AcademicEventService service;

    public AcademicEventController(AcademicEventService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody AcademicEvent event) {
        ApiResponse response = new ApiResponse(
                true,
                "Event created successfully",
                service.createEvent(event)
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody AcademicEvent event) {

        ApiResponse response = new ApiResponse(
                true,
                "Event updated successfully",
                service.updateEvent(id, event)
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                new ApiResponse(true, "Event fetched successfully",
                        service.getEventById(id))
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAll() {
        return ResponseEntity.ok(
                new ApiResponse(true, "Events fetched successfully",
                        service.getAllEvents())
        );
    }

    @GetMapping("/branch/{branchId}")
    public ResponseEntity<ApiResponse> getByBranch(@PathVariable Long branchId) {
        return ResponseEntity.ok(
                new ApiResponse(true, "Branch events fetched successfully",
                        service.getEventsByBranch(branchId))
        );
    }
}
