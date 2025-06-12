package com.example.service;

import com.example.dto.LoginResponse;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserServiceClient webClientService;

    public CustomUserDetailsService(UserServiceClient webClientService) {
        this.webClientService = webClientService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        LoginResponse user = webClientService.getUserByEmail(email).block();

        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + email);
        }

        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
