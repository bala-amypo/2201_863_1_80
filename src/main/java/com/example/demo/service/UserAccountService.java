package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    UserAccount register(UserAccount user);

    UserAccount findByEmail(String email);

    List<UserAccount> getAllUsers();

    UserAccount getUser(Long id);
}
