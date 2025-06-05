package com.example.controller;

import com.example.model.UserApp;
import com.example.service.UserAppService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/userId")
    public UserApp getUserById(@PathVariable Long userId) {
        return userAppService.getUserById(userId);
    }

    @PostMapping
    public UserApp createUser(@RequestBody UserApp userApp) {
        return userAppService.createUser(userApp);
    }

    @PutMapping
    public UserApp updateUser(@RequestBody UserApp userApp) {
        return userAppService.updateUser(userApp);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userAppService.deleteUser(userId);
    }

}
