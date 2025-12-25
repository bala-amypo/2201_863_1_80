package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BranchProfile {

    @Id
    @GeneratedValue
    private Long id;

    private String branchCode;
    private String branchName;
    private String contactEmail;
    private Boolean active;
    private LocalDateTime lastSyncAt;

    // ✅ No-args constructor (JPA + TESTS)
    public BranchProfile() {
    }

    // ✅ All-args constructor (USED IN TESTS)
    public BranchProfile(
            Long id,
            String branchCode,
            String branchName,
            String contactEmail,
            LocalDateTime lastSyncAt,
            Boolean active
    ) {
        this.id = id;
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.contactEmail = contactEmail;
        this.lastSyncAt = lastSyncAt;
        this.active = active;
    }

    // ✅ Tests call this directly
    @PrePersist
    public void prePersist() {
        if (this.lastSyncAt == null) {
            this.lastSyncAt = LocalDateTime.now();
        }
        if (this.active == null) {
            this.active = true;
        }
    }

    // =========================
    // GETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public Boolean getActive() {
        return active;
    }

    public LocalDateTime getLastSyncAt() {
        return lastSyncAt;
    }

    // =========================
    // SETTERS
    // =========================

    public void setId(Long id) {
        this.id = id;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setLastSyncAt(LocalDateTime lastSyncAt) {
        this.lastSyncAt = lastSyncAt;
    }
}
