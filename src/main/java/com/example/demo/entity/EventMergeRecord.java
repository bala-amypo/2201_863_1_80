package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class EventMergeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<Long> eventIds;

    private String reason;

    private LocalDate mergeDate;

    // ===== getters & setters =====

    public Long getId() {
        return id;
    }

    public List<Long> getEventIds() {
        return eventIds;
    }

    public void setEventIds(List<Long> eventIds) {
        this.eventIds = eventIds;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getMergeDate() {
        return mergeDate;
    }

    public void setMergeDate(LocalDate mergeDate) {
        this.mergeDate = mergeDate;
    }
}
