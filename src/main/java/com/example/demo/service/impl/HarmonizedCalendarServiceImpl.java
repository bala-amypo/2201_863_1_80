package com.example.demo.service.impl;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.repository.HarmonizedCalendarRepository;

public class HarmonizedCalendarServiceImpl {

    private final HarmonizedCalendarRepository repository;

    public HarmonizedCalendarServiceImpl(HarmonizedCalendarRepository repository) {
        this.repository = repository;
    }

    public HarmonizedCalendar generate(HarmonizedCalendar calendar) {
        return repository.save(calendar);
    }
}
