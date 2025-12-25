package com.example.demo.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService
        implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        // TEMP stub – replaced later with DB logic
        return new User(
                username,
                "$2a$10$7EqJtq98hPqEX7fNZaFWoOHi5zP1rQ2y7uZzYlZ5Zq4sF8ZP5Yl9K", 
                Collections.emptyList()
        );
    }
}
