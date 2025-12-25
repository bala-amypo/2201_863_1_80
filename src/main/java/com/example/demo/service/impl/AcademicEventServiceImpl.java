package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    private final AcademicEventRepository eventRepo;

    public AcademicEventServiceImpl(AcademicEventRepository eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public AcademicEvent createEvent(AcademicEvent event) {

        if (event.getStartDate().isAfter(event.getEndDate())) {
            throw new ValidationException(
                    "startDate cannot be after endDate");
        }

        return eventRepo.save(event);
    }

    @Override
    public AcademicEvent updateEvent(Long id, AcademicEvent event) {

        AcademicEvent existing = eventRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Event not found"));

        if (event.getStartDate().isAfter(event.getEndDate())) {
            throw new ValidationException(
                    "startDate cannot be after endDate");
        }

        event.setId(existing.getId());
        return eventRepo.save(event);
    }

    @Override
    public AcademicEvent getEventById(Long id) {
        return eventRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Event not found"));
    }

    @Override
    public List<AcademicEvent> getEventsByBranch(Long branchId) {
        return eventRepo.findByBranchId(branchId);
    }

    @Override
    public List<AcademicEvent> getAllEvents() {
        return eventRepo.findAll();
    }
}
