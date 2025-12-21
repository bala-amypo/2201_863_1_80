package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.*;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;

    public UserAccountServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserAccount create(UserAccount user) {
        if (repo.existsByEmail(user.getEmail())) {
            throw new ValidationException("Email already in use");
        }
        return repo.save(user);
    }

    @Override
    public UserAccount getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<UserAccount> getAll() {
        return repo.findAll();
    }

    @Override
    public UserAccount update(Long id, UserAccount user) {
        UserAccount existing = getById(id);
        existing.setFullName(user.getFullName());
        existing.setDepartment(user.getDepartment());
        existing.setRole(user.getRole());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        repo.delete(getById(id));
    }
}
