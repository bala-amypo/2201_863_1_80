package com.example.demo.service.impl;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HarmonizedCalendarRepository;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HarmonizedCalendarServiceImpl implements HarmonizedCalendarService {

    private final HarmonizedCalendarRepository repo;

    public HarmonizedCalendarServiceImpl(HarmonizedCalendarRepository repo) {
        this.repo = repo;
    }

    public HarmonizedCalendar generateHarmonizedCalendar(String title, String generatedBy) {
        HarmonizedCalendar cal = new HarmonizedCalendar();
        cal.setTitle(title);
        cal.setGeneratedBy(generatedBy);
        cal.setEffectiveFrom(LocalDate.now());
        cal.setEffectiveTo(LocalDate.now().plusMonths(6));
        cal.setEventsJson("[]");
        return repo.save(cal);
    }

    public HarmonizedCalendar getCalendarById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Calendar not found"));
    }

    public List<HarmonizedCalendar> getAllCalendars() {
        return repo.findAll();
    }

    public List<HarmonizedCalendar> getCalendarsWithinRange(LocalDate start, LocalDate end) {
        return repo.findByEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(start, end);
    }
}
