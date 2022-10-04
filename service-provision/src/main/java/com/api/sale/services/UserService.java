package com.api.sale.services;

import org.springframework.stereotype.Service;

import com.api.sale.entities.User;
import com.api.sale.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

}
