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

    public HarmonizedCalendar create(HarmonizedCalendar calendar) {
        return repo.save(calendar);
    }

    public HarmonizedCalendar getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Calendar not found"));
    }

    public List<HarmonizedCalendar> getAll() {
        return repo.findAll();
    }

    public List<HarmonizedCalendar> getByRange(LocalDate start, LocalDate end) {
        return repo
            .findByEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(start, end);
    }
}
