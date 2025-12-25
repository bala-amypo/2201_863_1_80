package com.example.demo.controller;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashDetectionService service;

    public ClashRecordController(ClashDetectionService service) {
        this.service = service;
    }

    @GetMapping("/branch/{branchId}")
    public List<ClashRecord> detectClashes(
            @PathVariable Long branchId) {
        return service.detectClashes(branchId);
    }
}
