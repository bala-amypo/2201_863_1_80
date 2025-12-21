package com.example.demo.service;

import com.example.demo.entity.HarmonizedCalendar;
import java.time.LocalDate;
import java.util.List;

public interface HarmonizedCalendarService {
    HarmonizedCalendar create(HarmonizedCalendar calendar);
    HarmonizedCalendar getById(Long id);
    List<HarmonizedCalendar> getAll();
    List<HarmonizedCalendar> getByRange(LocalDate start, LocalDate end);
}
