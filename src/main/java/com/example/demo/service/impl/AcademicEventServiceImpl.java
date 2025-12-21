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
    public AcademicEvent create(AcademicEvent event) {
        validateDates(event);
        return repo.save(event);
    }

    @Override
    public AcademicEvent update(Long id, AcademicEvent event) {
        AcademicEvent existing = getById(id);
        validateDates(event);

        existing.setTitle(event.getTitle());
        existing.setEventType(event.getEventType());
        existing.setStartDate(event.getStartDate());
        existing.setEndDate(event.getEndDate());
        existing.setLocation(event.getLocation());
        existing.setDescription(event.getDescription());
        existing.setBranchId(event.getBranchId());

        return repo.save(existing);
    }

    @Override
    public AcademicEvent getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    @Override
    public List<AcademicEvent> getAll() {
        return repo.findAll();
    }

    @Override
    public List<AcademicEvent> getByBranch(Long branchId) {
        return repo.findByBranchId(branchId);
    }

    @Override
    public void delete(Long id) {
        repo.delete(getById(id));
    }

    private void validateDates(AcademicEvent event) {
        if (event.getStartDate() != null &&
            event.getEndDate() != null &&
            event.getStartDate().isAfter(event.getEndDate())) {
            throw new ValidationException("startDate cannot be after endDate");
        }
    }
}
