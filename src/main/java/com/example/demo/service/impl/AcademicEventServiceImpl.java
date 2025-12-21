package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    private final AcademicEventRepository repo;

    public AcademicEventServiceImpl(AcademicEventRepository repo) {
        this.repo = repo;
    }

    @Override
    public AcademicEvent create(AcademicEvent event) {
        return repo.save(event);
    }

    @Override
    public AcademicEvent update(Long id, AcademicEvent event) {
        AcademicEvent existing = repo.findById(id).orElseThrow();
        existing.setEventName(event.getEventName());
        existing.setEventDate(event.getEventDate());
        existing.setBranch(event.getBranch());
        return repo.save(existing);
    }

    @Override
    public AcademicEvent getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public List<AcademicEvent> getAll() {
        return repo.findAll();
    }

    @Override
    public List<AcademicEvent> getByBranch(Long branchId) {
        return repo.findByBranchId(branchId);
    }
}
