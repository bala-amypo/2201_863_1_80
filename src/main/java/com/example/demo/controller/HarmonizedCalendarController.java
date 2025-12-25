package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/harmonized-calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService service;

    public HarmonizedCalendarController(
            HarmonizedCalendarService service) {
        this.service = service;
    }

    @PostMapping("/generate")
    public HarmonizedCalendar generate(
            @RequestParam String title,
            @RequestParam String generatedBy) {

        return service.generateCalendar(title, generatedBy);
    }
}
