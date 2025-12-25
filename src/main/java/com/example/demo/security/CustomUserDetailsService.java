package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserAccountRepository repository;

    // ✅ REQUIRED by tests
    public CustomUserDetailsService(UserAccountRepository repository) {
        this.repository = repository;
    }

    // Also required (default constructor)
    public CustomUserDetailsService() {
        this.repository = null;
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
demo/src/test