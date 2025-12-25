package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.service.ClashRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashRecordService service;

    public ClashRecordController(ClashRecordService service) {
        this.service = service;
    }

    @GetMapping("/branch/{branchId}")
    public ApiResponse getByBranch(@PathVariable Long branchId) {
        return ApiResponse.success(service.getByBranch(branchId));
    }
}
