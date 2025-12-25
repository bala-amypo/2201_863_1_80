package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.*;

public class JwtUtil {

    private SecretKey key;

    public void initKey() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(key)
                .compact();
    }

    public String generateTokenForUser(UserAccount ua) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", ua.getEmail());
        claims.put("role", ua.getRole());
        claims.put("userId", ua.getId());
        return generateToken(claims, ua.getEmail());
    }

    public Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUsername(String token) {
        return parseToken(token).getSubject();
    }

    public String extractRole(String token) {
        return (String) parseToken(token).get("role");
    }

    public Long extractUserId(String token) {
        Object id = parseToken(token).get("userId");
        return id == null ? null : Long.valueOf(id.toString());
    }

    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username);
    }
}
