package com.example.repository;

import com.example.model.TaskTag;
import com.example.model.TaskTagId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskTagRepository extends JpaRepository<TaskTag, TaskTagId> {
    List<TaskTag> findByIdTaskId(Long taskId);
}
