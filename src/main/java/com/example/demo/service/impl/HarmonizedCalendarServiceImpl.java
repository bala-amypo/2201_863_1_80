package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HarmonizedCalendarRepository;
import com.example.demo.service.HarmonizedCalendarService;

@Service
public class HarmonizedCalendarServiceImpl
        implements HarmonizedCalendarService {

    private final HarmonizedCalendarRepository calendarRepo;

    public HarmonizedCalendarServiceImpl(
            HarmonizedCalendarRepository calendarRepo) {
        this.calendarRepo = calendarRepo;
    }

    @Override
    public HarmonizedCalendar generateHarmonizedCalendar(
            String title, String generatedBy) {

        HarmonizedCalendar calendar = new HarmonizedCalendar();
        calendar.setTitle(title);
        calendar.setGeneratedBy(generatedBy);
        calendar.setEffectiveFrom(LocalDate.now());
        calendar.setEffectiveTo(LocalDate.now().plusMonths(6));
        calendar.setEventsJson("[]");

        return calendarRepo.save(calendar);
    }

    @Override
    public HarmonizedCalendar getCalendarById(Long id) {
        return calendarRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Calendar not found"));
    }

    @Override
    public List<HarmonizedCalendar> getAllCalendars() {
        return calendarRepo.findAll();
    }

    @Override
    public List<HarmonizedCalendar> getCalendarsWithinRange(
            LocalDate start, LocalDate end) {
        return calendarRepo
                .findByEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(
                        start, end);
    }
}
