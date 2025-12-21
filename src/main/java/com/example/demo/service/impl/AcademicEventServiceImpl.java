package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    private final AcademicEventRepository repo;

    public AcademicEventServiceImpl(AcademicEventRepository repo) {
        this.repo = repo;
    }

    @Override
    public AcademicEvent createEvent(AcademicEvent event) {
        if (event.getStartDate().isAfter(event.getEndDate()))
            throw new ValidationException("startDate cannot be after endDate");
        return repo.save(event);
    }

    @Override
    public AcademicEvent updateEvent(Long id, AcademicEvent event) {
        AcademicEvent existing = getEventById(id);
        event.setId(existing.getId());
        return createEvent(event);
    }

    @Override
    public AcademicEvent getEventById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    @Override
    public List<AcademicEvent> getEventsByBranch(Long branchId) {
        return repo.findByBranchId(branchId);
    }

    @Override
    public List<AcademicEvent> getAllEvents() {
        return repo.findAll();
    }
}
