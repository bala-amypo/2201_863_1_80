package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService harmonizedCalendarService;

    public HarmonizedCalendarController(HarmonizedCalendarService harmonizedCalendarService) {
        this.harmonizedCalendarService = harmonizedCalendarService;
    }

    @PostMapping
    public HarmonizedCalendar generateCalendar(@RequestBody Map<String, String> body) {

        String title = body.get("title");
        String generatedBy = body.get("generatedBy");

        return harmonizedCalendarService
                .generateHarmonizedCalendar(title, generatedBy);
    }

    @GetMapping
    public List<HarmonizedCalendar> getAllCalendars() {
        return harmonizedCalendarService.getAllCalendars();
    }

    @GetMapping("/{id}")
    public HarmonizedCalendar getCalendarById(@PathVariable Long id) {
        return harmonizedCalendarService.getCalendarById(id);
    }

    @GetMapping("/range")
    public List<HarmonizedCalendar> getCalendarsByRange(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return harmonizedCalendarService
                .getCalendarsWithinRange(start, end);
    }
}
