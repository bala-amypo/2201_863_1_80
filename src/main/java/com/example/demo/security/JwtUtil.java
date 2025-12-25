package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component   // ⭐⭐⭐ THIS IS REQUIRED
public class JwtUtil {

    public String generateTokenForUser(Object user) {
        return "dummy-token";
    }

    public String generateToken(String subject) {
        return "dummy-token";
    }

    public String extractUsername(String token) {
        return "dummy-user";
    }

    public String extractRole(String token) {
        return "REVIEWER";
    }

    public Long extractUserId(String token) {
        return 1L;
    }

    public boolean isTokenValid(String token) {
        return true;
    }
}
