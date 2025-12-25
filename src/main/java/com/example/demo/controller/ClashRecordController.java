package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashRecordService;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashRecordService service;

    public ClashRecordController(ClashRecordService service) {
        this.service = service;
    }

    @GetMapping("/branch/{branchId}")
    public List<ClashRecord> getByBranch(@PathVariable Long branchId) {
        return service.getByBranch(branchId);
    }
}
