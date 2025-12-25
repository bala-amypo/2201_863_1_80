package com.example.demo.controller;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clashes")
public class ClashRecordController {

    private final ClashDetectionService service;

    public ClashRecordController(ClashDetectionService service) {
        this.service = service;
    }

    @PostMapping
    public ClashRecord save(@RequestBody ClashRecord record) {
        return service.save(record);
    }

    @PutMapping("/{id}/resolve")
    public ClashRecord resolve(@PathVariable Long id) {
        return service.resolve(id);
    }
}
