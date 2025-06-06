package com.example.repository;

import com.example.model.GroupApp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupAppRepository extends JpaRepository<GroupApp, Long> {
    GroupApp findByTitle(String title);
    List<GroupApp> findByProjectId(Long projectId);
}
