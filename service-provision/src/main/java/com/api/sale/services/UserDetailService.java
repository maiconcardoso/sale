package com.api.sale.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.sale.entities.User;
import com.api.sale.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User login = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Login não encontrado!"));
        return org.springframework.security.core.userdetails.User
            .builder()
            .username(login.getUsername())
            .password(login.getPassword())
            .roles("USER")
            .build();
    }

}
