package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.service.ClashDetectionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashDetectionService service;

    public ClashRecordController(ClashDetectionService service) {
        this.service = service;
    }

    @GetMapping("/branch/{branchId}")
    public ApiResponse getByBranch(@PathVariable Long branchId) {
        return new ApiResponse(true, "Clashes fetched successfully",
                service.detectClashes(branchId));
    }
}
