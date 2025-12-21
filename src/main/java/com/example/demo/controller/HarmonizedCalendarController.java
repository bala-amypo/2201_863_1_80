package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;

@RestController
@RequestMapping("/api/harmonized-calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService calendarService;

    public HarmonizedCalendarController(HarmonizedCalendarService calendarService) {
        this.calendarService = calendarService;
    }

    // POST /generate – Generate a harmonized calendar
    @PostMapping("/generate")
    public ResponseEntity<HarmonizedCalendar> generate(
            @RequestParam String title,
            @RequestParam String generatedBy) {
        return ResponseEntity.ok(calendarService.generateHarmonizedCalendar(title, generatedBy));
    }

    // GET /{id} – Get calendar by ID
    @GetMapping("/{id}")
    public ResponseEntity<HarmonizedCalendar> getById(@PathVariable Long id) {
        return ResponseEntity.ok(calendarService.getCalendarById(id));
    }

    // GET / – List all calendars
    @GetMapping
    public ResponseEntity<List<HarmonizedCalendar>> getAll() {
        return ResponseEntity.ok(calendarService.getAllCalendars());
    }

    // GET /range – Get calendars within date range
    @GetMapping("/range")
    public ResponseEntity<List<HarmonizedCalendar>> getByRange(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return ResponseEntity.ok(calendarService.getCalendarsWithinRange(start, end));
    }
}
