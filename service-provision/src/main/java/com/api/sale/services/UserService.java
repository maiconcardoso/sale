package com.api.sale.services;

import org.springframework.stereotype.Service;

import com.api.sale.entities.User;
import com.api.sale.exceptions.UsernameRegisteredException;
import com.api.sale.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;

    public User save(User user) {
        boolean existsUsername = userRepository.existsByUsername(user.getUsername());
        if (existsUsername) {
            throw new UsernameRegisteredException(user.getUsername());
        }
        return userRepository.save(user);
    }

}
