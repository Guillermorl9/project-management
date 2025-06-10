package com.example.service;

import com.example.model.TaskUser;
import com.example.model.TaskUserId;
import com.example.repository.TaskUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskUserService {

    private final TaskUserRepository taskUserRepository;

    public void assignUserToTask(Long taskId, Long userId) {
        TaskUserId taskUserId = new TaskUserId(taskId, userId);
        TaskUser taskUser = new TaskUser(taskUserId);
        taskUserRepository.save(taskUser);
    }

    public void removeUserFromTask(Long taskId, Long userId) {
        TaskUserId taskUserId = new TaskUserId(taskId, userId);
        taskUserRepository.deleteById(taskUserId);
    }

    public List<TaskUser> getUsersByTaskId(Long taskId) {
        return taskUserRepository.findByIdTaskId(taskId);
    }
}
