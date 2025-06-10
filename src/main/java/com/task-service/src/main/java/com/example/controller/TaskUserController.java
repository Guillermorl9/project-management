package com.example.controller;

import com.example.model.TaskUser;
import com.example.service.TaskUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/users")
@RequiredArgsConstructor
public class TaskUserController {

    private final TaskUserService taskUserService;

    @GetMapping
    public List<Long> getUserIdsByTaskId(@PathVariable Long taskId) {
        List<TaskUser> taskUsers = taskUserService.getUsersByTaskId(taskId);
        return taskUsers.stream().map(taskUser -> taskUser.getId().getUserId()).toList();
    }

    @PostMapping("/{userId}")
    public void assignUserToTask(@PathVariable Long taskId, @PathVariable Long userId) {
        taskUserService.assignUserToTask(taskId, userId);
    }

    @DeleteMapping("/{userId}")
    public void removeUserFromTask(@PathVariable Long taskId, @PathVariable Long userId) {
        taskUserService.removeUserFromTask(taskId, userId);
    }

}
