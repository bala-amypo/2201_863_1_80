package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService harmonizedCalendarService;

    public HarmonizedCalendarController(HarmonizedCalendarService harmonizedCalendarService) {
        this.harmonizedCalendarService = harmonizedCalendarService;
    }

    @PostMapping("/generate")
    public ResponseEntity<HarmonizedCalendar> generateHarmonizedCalendar(@RequestBody Map<String, String> request) {
        String title = request.get("title");
        String generatedBy = request.get("generatedBy");
        HarmonizedCalendar calendar = harmonizedCalendarService.generateHarmonizedCalendar(title, generatedBy);
        return ResponseEntity.ok(calendar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HarmonizedCalendar> getCalendarById(@PathVariable Long id) {
        HarmonizedCalendar calendar = harmonizedCalendarService.getCalendarById(id);
        return ResponseEntity.ok(calendar);
    }

    @GetMapping
    public ResponseEntity<List<HarmonizedCalendar>> getAllCalendars() {
        List<HarmonizedCalendar> calendars = harmonizedCalendarService.getAllCalendars();
        return ResponseEntity.ok(calendars);
    }

    @GetMapping("/range")
    public ResponseEntity<List<HarmonizedCalendar>> getCalendarsWithinRange(@RequestParam LocalDate start, @RequestParam LocalDate end) {
        List<HarmonizedCalendar> calendars = harmonizedCalendarService.getCalendarsWithinRange(start, end);
        return ResponseEntity.ok(calendars);
    }
}