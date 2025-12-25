package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.EventMergeRequest;
import com.example.demo.service.EventMergeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/merge-records")
public class EventMergeController {

    private final EventMergeService service;

    public EventMergeController(EventMergeService service) {
        this.service = service;
    }

    @PostMapping
    public ApiResponse merge(@Valid @RequestBody EventMergeRequest request) {
        return new ApiResponse(true, "Events merged successfully",
                service.mergeEvents(request.getEventIds(), request.getReason()));
    }

    @GetMapping
    public ApiResponse history() {
        return new ApiResponse(true, "Merge history fetched successfully",
                service.getMergeHistory());
    }
}
