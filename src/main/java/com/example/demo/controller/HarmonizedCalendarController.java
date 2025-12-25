package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;

@RestController
@RequestMapping("/api/harmonized-calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService calendarService;

    public HarmonizedCalendarController(
            HarmonizedCalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @PostMapping("/generate")
    public HarmonizedCalendar generate(
            @RequestParam String title,
            @RequestParam String generatedBy) {
        return calendarService
                .generateHarmonizedCalendar(title, generatedBy);
    }

    @GetMapping("/{id}")
    public HarmonizedCalendar getById(@PathVariable Long id) {
        return calendarService.getCalendarById(id);
    }

    @GetMapping
    public List<HarmonizedCalendar> getAll() {
        return calendarService.getAllCalendars();
    }

    @GetMapping("/range")
    public List<HarmonizedCalendar> getByRange(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return calendarService.getCalendarsWithinRange(start, end);
    }
}
