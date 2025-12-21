package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.EventMergeRecord;

public interface EventMergeRepository extends JpaRepository<EventMergeRecord, Long> {

    List<EventMergeRecord> findByMergeDateBetween(LocalDate start, LocalDate end);
}
