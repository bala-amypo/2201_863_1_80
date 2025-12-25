package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class ClashRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long branchId;          // ⭐ REQUIRED (THIS FIXES EVERYTHING)

    private Long eventAId;

    private Long eventBId;

    private String severity;

    private LocalDateTime detectedAt;

    public ClashRecord() {}

    public Long getId() {
        return id;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Long getEventAId() {
        return eventAId;
    }

    public void setEventAId(Long eventAId) {
        this.eventAId = eventAId;
    }

    public Long getEventBId() {
        return eventBId;
    }

    public void setEventBId(Long eventBId) {
        this.eventBId = eventBId;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }

    public void setDetectedAt(LocalDateTime detectedAt) {
        this.detectedAt = detectedAt;
    }
}
