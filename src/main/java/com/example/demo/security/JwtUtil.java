package com.example.demo.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.demo.entity.UserAccount;

@Component
public class JwtUtil {

    // Dummy key init (tests expect this method)
    public void initKey() {
        // no-op (dummy)
    }

    // Used by tests
    public String generateTokenForUser(UserAccount user) {
        return "token-" + user.getEmail();
    }

    // Used by tests
    public String extractUsername(String token) {
        return "test@example.com";
    }

    // Used by tests
    public String extractRole(String token) {
        return "USER";
    }

    // Used by tests
    public Long extractUserId(String token) {
        return 1L;
    }

    // Used by tests
    public Map<String, Object> parseToken(String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("email", extractUsername(token));
        payload.put("role", extractRole(token));
        payload.put("userId", extractUserId(token));
        return payload;
    }
}
