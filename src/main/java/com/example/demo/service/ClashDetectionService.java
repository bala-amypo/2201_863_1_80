package com.example.demo.service;

import com.example.demo.entity.ClashRecord;
import java.util.List;

public interface ClashDetectionService {
    ClashRecord create(ClashRecord clash);
    ClashRecord resolve(Long id);
    ClashRecord getById(Long id);
    List<ClashRecord> getAll();
    List<ClashRecord> getUnresolved();
}
