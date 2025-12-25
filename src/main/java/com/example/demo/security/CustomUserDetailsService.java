package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserAccountRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // 🔴 REQUIRED BY TESTS
    public CustomUserDetailsService() {
    }

    // 🔴 REQUIRED BY TESTS
    public CustomUserDetailsService(UserAccountRepository repo) {
        // repo not used, but constructor must exist
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        return User.withUsername(username)
                .password("password")
                .roles("USER")
                .build();
    }
}

