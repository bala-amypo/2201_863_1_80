package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.EventMergeRequest;
import com.example.demo.service.EventMergeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/merge-records")
public class EventMergeController {

    private final EventMergeService service;

    public EventMergeController(EventMergeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> merge(@Valid @RequestBody EventMergeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(true, "Events merged successfully",
                        service.mergeEvents(request.getEventIds(), request.getReason())));
    }

    @GetMapping
    public ResponseEntity<ApiResponse> history() {
        return ResponseEntity.ok(
                new ApiResponse(true, "Merge history fetched successfully",
                        service.getMergeHistory()));
    }
}
