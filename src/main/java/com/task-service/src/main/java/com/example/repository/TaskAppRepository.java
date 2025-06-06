package com.example.repository;

import com.example.model.TaskApp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskAppRepository extends JpaRepository<TaskApp, Long> {
    List<TaskApp> findAllByProjectId(String projectId);
}
