package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String subject) {
        return "dummy-token";
    }

    public String getUsername(String token) {
        return "dummy-user";
    }

    public boolean isTokenValid(String token, String username) {
        return true;
    }
}
