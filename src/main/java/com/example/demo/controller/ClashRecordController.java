package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashDetectionService clashService;

    public ClashRecordController(ClashDetectionService clashService) {
        this.clashService = clashService;
    }

    
    @PostMapping
    public ResponseEntity<ClashRecord> log(@RequestBody ClashRecord clash) {
        return ResponseEntity.ok(clashService.logClash(clash));
    }

    
    @PutMapping("/{id}/resolve")
    public ResponseEntity<ClashRecord> resolve(@PathVariable Long id) {
        return ResponseEntity.ok(clashService.resolveClash(id));
    }

    
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<ClashRecord>> getByEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(clashService.getClashesForEvent(eventId));
    }

    
    @GetMapping("/unresolved")
    public ResponseEntity<List<ClashRecord>> getUnresolved() {
        return ResponseEntity.ok(clashService.getUnresolvedClashes());
    }

    
    @GetMapping
    public ResponseEntity<List<ClashRecord>> getAll() {
        return ResponseEntity.ok(clashService.getAllClashes());
    }
}
