package com.example.demo.controller;

import java.util.List;
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
    public ClashRecord logClash(@RequestBody ClashRecord clash) {
        return clashService.logClash(clash);
    }

    @GetMapping("/event/{eventId}")
    public List<ClashRecord> getClashes(@PathVariable Long eventId) {
        return clashService.getClashesForEvent(eventId);
    }

    @PutMapping("/{id}/resolve")
    public ClashRecord resolve(@PathVariable Long id) {
        return clashService.resolveClash(id);
    }

    @GetMapping("/unresolved")
    public List<ClashRecord> getUnresolved() {
        return clashService.getUnresolvedClashes();
    }

    @GetMapping
    public List<ClashRecord> getAll() {
        return clashService.getAllClashes();
    }
}
