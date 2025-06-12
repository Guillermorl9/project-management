package com.example.service;

import com.example.model.UserApp;
import com.example.repository.UserAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAppService {

    private final UserAppRepository userAppRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UserApp> getAllUsers() {
        return userAppRepository.findAll();
    }

    public UserApp saveUserData(String email, String name, String lastname, String password) {
        if (userAppRepository.findByEmail(email) != null) {
            throw new IllegalArgumentException("Email already exists");
        }

        UserApp userApp = new UserApp();
        userApp.setEmail(email);
        userApp.setName(name);
        userApp.setPassword(passwordEncoder.encode(password));
        userApp.setLastname(lastname);

        return userAppRepository.save(userApp);
    }

    public UserApp findByEmail(String email) {
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

        return userAppRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userAppRepository.deleteById(id);
    }

}
