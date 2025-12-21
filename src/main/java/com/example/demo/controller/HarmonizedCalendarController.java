package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/harmonized-calendars")
@Tag(name = "Harmonized Calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService service;

    public HarmonizedCalendarController(HarmonizedCalendarService service) {
        this.service = service;
    }

    @PostMapping
    public HarmonizedCalendar create(@RequestBody HarmonizedCalendar calendar) {
        return service.create(calendar);
    }

    @GetMapping("/{id}")
    public HarmonizedCalendar get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<HarmonizedCalendar> getAll() {
        return service.getAll();
    }

    @GetMapping("/range")
    public List<HarmonizedCalendar> getByRange(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return service.getByRange(start, end);
    }
}
