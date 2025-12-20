package com.example.demo.controller;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clashes")
public class ClashDetectionController {

    private final ClashDetectionService clashDetectionService;

    public ClashDetectionController(ClashDetectionService clashDetectionService) {
        this.clashDetectionService = clashDetectionService;
    }

    @PostMapping
    public ResponseEntity<ClashRecord> logClash(@RequestBody ClashRecord clash) {
        ClashRecord loggedClash = clashDetectionService.logClash(clash);
        return ResponseEntity.ok(loggedClash);
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<ClashRecord> resolveClash(@PathVariable Long id) {
        ClashRecord resolvedClash = clashDetectionService.resolveClash(id);
        return ResponseEntity.ok(resolvedClash);
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<ClashRecord>> getClashesForEvent(@PathVariable Long eventId) {
        List<ClashRecord> clashes = clashDetectionService.getClashesForEvent(eventId);
        return ResponseEntity.ok(clashes);
    }

    @GetMapping("/unresolved")
    public ResponseEntity<List<ClashRecord>> getUnresolvedClashes() {
        List<ClashRecord> clashes = clashDetectionService.getUnresolvedClashes();
        return ResponseEntity.ok(clashes);
    }

    @GetMapping
    public ResponseEntity<List<ClashRecord>> getAllClashes() {
        List<ClashRecord> clashes = clashDetectionService.getAllClashes();
        return ResponseEntity.ok(clashes);
    }
}