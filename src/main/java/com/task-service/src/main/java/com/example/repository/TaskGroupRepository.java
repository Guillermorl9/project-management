package com.example.repository;

import com.example.model.TaskGroup;
import com.example.model.TaskGroupId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskGroupRepository extends JpaRepository<TaskGroup, TaskGroupId> {
    List<TaskGroup> findByIdTaskId(Long taskId);
}
