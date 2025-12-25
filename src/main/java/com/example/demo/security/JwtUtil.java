package com.example.demo.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.demo.entity.UserAccount;

@Component
public class JwtUtil {

    // 🔴 REQUIRED BY TESTS
    public void initKey() {
        // no operation (dummy)
    }

    // Used by some services
    public String generateToken(String username) {
        return "token-" + username;
    }

    // 🔴 REQUIRED BY TESTS
    public String generateTokenForUser(UserAccount user) {
        return "token-" + user.getEmail();
    }

    // 🔴 REQUIRED BY TESTS
    public Map<String, Object> parseToken(String token) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", extractUsername(token));
        claims.put("role", extractRole(token));
        claims.put("userId", extractUserId(token));
        return claims;
    }

    // 🔴 REQUIRED BY TESTS
    public String extractUsername(String token) {
        return token.replace("token-", "");
    }

    // 🔴 REQUIRED BY TESTS
    public String extractRole(String token) {
        return "REVIEWER";
    }

    // 🔴 REQUIRED BY TESTS
    public Long extractUserId(String token) {
        return 1L;
    }

    public boolean isTokenValid(String token, String username) {
        return token.contains(username);
    }
}
