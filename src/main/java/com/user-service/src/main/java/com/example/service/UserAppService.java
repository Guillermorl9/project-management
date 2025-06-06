package com.example.service;

import com.example.model.UserApp;
import com.example.repository.UserAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAppService {

    private final UserAppRepository userAppRepository;

    public List<UserApp> getAllUsers() {
        return userAppRepository.findAll();
    }

    public UserApp getUserByEmail(String email) {
        return userAppRepository.findByEmail(email);
    }

    public UserApp getUserById(Long id) {
        return userAppRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public UserApp createUser(UserApp userApp) {
        return userAppRepository.save(userApp);
    }

    public UserApp updateUser(Long userId, UserApp userApp) {
        UserApp existingUser = userAppRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        existingUser.setEmail(userApp.getEmail());
        existingUser.setName(userApp.getName());
        existingUser.setLastname(userApp.getLastname());
        existingUser.setPassword(userApp.getPassword());

        return userAppRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userAppRepository.deleteById(id);
    }

}
