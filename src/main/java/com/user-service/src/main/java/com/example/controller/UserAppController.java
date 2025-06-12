package com.example.controller;

import com.example.dto.LoginResponse;
import com.example.dto.UserAppDto;
import com.example.mapper.UserAppMapper;
import com.example.model.UserApp;
import com.example.service.UserAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserAppController {

    private final UserAppService userAppService;

    @GetMapping
    public List<UserApp> getAllUsers() {
        return userAppService.getAllUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserApp userApp) {
        UserApp existingUser = userAppService.findByEmail(userApp.getEmail());

        if (existingUser != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Mail already exists");
        }

        UserApp newUserApp = userAppService.saveUserData(
                userApp.getEmail(), userApp.getName(), userApp.getLastname(), userApp.getPassword());
        UserAppDto userAppDto = UserAppMapper.toDto(newUserApp);
        return ResponseEntity.status(HttpStatus.CREATED).body(userAppDto);
    }

    @GetMapping("/by-email")
    public LoginResponse getUserByEmail(@RequestParam String email) {
        System.out.println("Email recibido: " + email);
        UserApp userApp = userAppService.findByEmail(email);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setEmail(userApp.getEmail());
        loginResponse.setPassword(userApp.getPassword());

        return loginResponse;
    }

    @GetMapping("/{userId}")
    public UserApp getUserById(@PathVariable Long userId) {
        return userAppService.getUserById(userId);
    }

    @PostMapping
    public UserApp createUser(@RequestBody UserApp userApp) {
        return userAppService.createUser(userApp);
    }

    @PutMapping("/{userId}")
    public UserApp updateUser(@PathVariable Long userId, @RequestBody UserApp userApp) {
        return userAppService.updateUser(userId, userApp);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userAppService.deleteUser(userId);
    }

}
