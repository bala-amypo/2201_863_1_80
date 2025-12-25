package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AcademicEventRepository;

import java.util.List;

public class AcademicEventServiceImpl {

    private final AcademicEventRepository repository;

    public AcademicEventServiceImpl(AcademicEventRepository repository) {
        this.repository = repository;
    }

    public AcademicEvent createEvent(AcademicEvent event) {
        return repository.save(event);
    }

    public AcademicEvent getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    public List<AcademicEvent> getByBranchId(Long branchId) {
        return repository.findByBranchId(branchId);
    }
}
