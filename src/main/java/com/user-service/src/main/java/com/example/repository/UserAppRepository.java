package com.example.repository;

import com.example.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAppRepository extends JpaRepository<UserApp, Long> {
    UserApp findByEmail(String email);
}
