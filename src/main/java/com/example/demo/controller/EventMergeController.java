package com.example.demo.controller;

import com.example.demo.dto.EventMergeRequest;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/merge-records")
public class EventMergeController {

    private final EventMergeService service;

    public EventMergeController(EventMergeService service) {
        this.service = service;
    }

    @PostMapping
    public EventMergeRecord mergeEvents(
            @Valid @RequestBody EventMergeRequest request) {

        return service.mergeEvents(
                request.getEventIds(),
                request.getReason()
        );
    }

    @GetMapping
    public List<EventMergeRecord> getMergeHistory() {
        return service.getMergeHistory();
    }
}
