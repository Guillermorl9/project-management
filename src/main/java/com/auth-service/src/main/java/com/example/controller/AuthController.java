package com.example.controller;

import com.example.dto.LoginResponse;
import com.example.dto.AuthResponse;
import com.example.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginResponse loginResponse) {
        AuthResponse response = authService.login(loginResponse);
        return ResponseEntity.ok(response);
    }
}
