package com.example.controller;

import com.example.model.TaskGroup;
import com.example.service.TaskGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/groups")
@RequiredArgsConstructor
public class TaskGroupController {

    private final TaskGroupService taskGroupService;

    @GetMapping
    public List<Long> getGroupIdsByTaskId(@PathVariable Long taskId) {
        List<TaskGroup> taskGroups = taskGroupService.getGroupsByTaskId(taskId);
        return taskGroups.stream()
                .map(tg -> tg.getId().getGroupId())
                .toList();
    }

    @PostMapping("/{groupId}")
    public void assignGroupToTask(@PathVariable Long taskId, @PathVariable Long groupId) {
        taskGroupService.assignGroupToTask(taskId, groupId);
    }

    @DeleteMapping("/{groupId}")
    public void removeGroupFromTask(@PathVariable Long taskId, @PathVariable Long groupId) {
        taskGroupService.removeGroupFromTask(taskId, groupId);
    }
}
