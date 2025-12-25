package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/harmonized-calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService service;

    public HarmonizedCalendarController(HarmonizedCalendarService service) {
        this.service = service;
    }

    @PostMapping("/generate")
    public ResponseEntity<ApiResponse> generate(
            @RequestParam String title,
            @RequestParam String generatedBy) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(true,
                        "Harmonized calendar generated successfully",
                        service.generateCalendar(title, generatedBy)));
    }
}
