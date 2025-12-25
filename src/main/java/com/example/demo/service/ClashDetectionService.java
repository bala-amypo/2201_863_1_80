package com.example.demo.service;

import com.example.demo.entity.ClashRecord;

public interface ClashDetectionService {

    ClashRecord save(ClashRecord record);

    ClashRecord resolve(Long id);
}
