package com.example.service;

import com.example.dto.AuthResponse;
import com.example.dto.LoginResponse;
import com.example.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserServiceClient userServiceClient;

    public AuthResponse login(LoginResponse loginRequest) {
        LoginResponse userRequest = userServiceClient.getUserByEmail(loginRequest.getEmail()).block();

        if (userRequest == null || userRequest.getPassword() == null) {
            throw new RuntimeException("Invalid email or password");
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );

        String token = jwtUtil.generateToken(loginRequest.getEmail());

        return new AuthResponse(token);
    }
}
