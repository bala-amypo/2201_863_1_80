package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.ApiResponse;
import com.example.demo.service.ClashRecordService;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashRecordService service;

    public ClashRecordController(ClashRecordService service) {
        this.service = service;
    }

    @GetMapping("/branch/{branchId}")
    public ApiResponse getByBranch(@PathVariable Long branchId) {
        return new ApiResponse(
                true,
                "Clashes fetched successfully",
                service.getByBranch(branchId)
        );
    }
}
