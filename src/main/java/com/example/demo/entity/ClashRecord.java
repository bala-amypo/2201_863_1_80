package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ClashRecord {

    @Id
    @GeneratedValue
    private Long id;

    private Long eventAId;
    private Long eventBId;
    private String clashType;
    private String severity;
    private String details;
    private Boolean resolved;
    private LocalDateTime detectedAt;

    // ✅ No-args constructor (JPA + TESTS)
    public ClashRecord() {
    }

    // ✅ All-args constructor (USED IN TESTS)
    public ClashRecord(
            Long id,
            Long eventAId,
            Long eventBId,
            String clashType,
            String severity,
            String details,
            LocalDateTime detectedAt,
            Boolean resolved
    ) {
        this.id = id;
        this.eventAId = eventAId;
        this.eventBId = eventBId;
        this.clashType = clashType;
        this.severity = severity;
        this.details = details;
        this.detectedAt = detectedAt;
        this.resolved = resolved;
    }

    // ✅ Tests call this directly
    @PrePersist
    public void prePersist() {
        if (this.detectedAt == null) {
            this.detectedAt = LocalDateTime.now();
        }
        if (this.resolved == null) {
            this.resolved = false;
        }
    }

    // =========================
    // GETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public Long getEventAId() {
        return eventAId;
    }

    public Long getEventBId() {
        return eventBId;
    }

    public String getClashType() {
        return clashType;
    }

    public String getSeverity() {
        return severity;
    }

    public String getDetails() {
        return details;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }

    // =========================
    // SETTERS
    // =========================

    public void setId(Long id) {
        this.id = id;
    }

    public void setEventAId(Long eventAId) {
        this.eventAId = eventAId;
    }

    public void setEventBId(Long eventBId) {
        this.eventBId = eventBId;
    }

    public void setClashType(String clashType) {
        this.clashType = clashType;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }

    public void setDetectedAt(LocalDateTime detectedAt) {
        this.detectedAt = detectedAt;
    }
}
