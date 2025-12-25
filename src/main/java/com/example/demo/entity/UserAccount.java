package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue
    private Long id;

    private String fullName;
    private String email;
    private String password;
    private String role;
    private String department;
    private LocalDateTime createdAt;

    // ✅ No-args constructor (REQUIRED by JPA + TESTS)
    public UserAccount() {
    }

    // ✅ All-args constructor (REQUIRED by TESTS)
    public UserAccount(
            Long id,
            String fullName,
            String email,
            String password,
            String role,
            String department,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.department = department;
        this.createdAt = createdAt;
    }

    // ✅ PrePersist method (TESTS CALL THIS DIRECTLY)
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.role == null) {
            this.role = "REVIEWER";
        }
    }

    // =========================
    // GETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getDepartment() {
        return department;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // =========================
    // SETTERS
    // =========================

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
