package com.example.demo.service;

import com.example.demo.entity.AcademicEvent;
import java.util.List;

public interface AcademicEventService {

    AcademicEvent createEvent(AcademicEvent event);

    AcademicEvent getById(Long id);

    List<AcademicEvent> getByBranchId(Long branchId);
}
