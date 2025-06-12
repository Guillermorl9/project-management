package com.example.controller;

import com.example.dto.LoginResponse;
import com.example.dto.AuthResponse;
import com.example.security.JwtUtil;
import com.example.service.UserServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserServiceClient userServiceClient;

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginResponse loginResponse) {
        System.out.println("Recbiendo petición..." + loginResponse);
        LoginResponse userResponse = userServiceClient.getUserByEmail(loginResponse.getEmail()).block();

        if (userResponse == null || userResponse.getPassword() == null) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginResponse.getEmail(), loginResponse.getPassword())
        );
        String token = jwtUtil.generateToken(loginResponse.getEmail());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
