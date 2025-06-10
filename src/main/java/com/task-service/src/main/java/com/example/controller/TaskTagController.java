package com.example.controller;

import com.example.model.TaskTag;
import com.example.service.TaskTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/tags")
@RequiredArgsConstructor
public class TaskTagController {

    private final TaskTagService taskTagService;

    @GetMapping
    public List<Long> getTagIdsByTaskId(@PathVariable Long taskId) {
        List<TaskTag> taskTags = taskTagService.getTagsByTaskId(taskId);
        return taskTags.stream().map(taskTag -> taskTag.getId().getTagId()).toList();
    }

    @PostMapping("/{tagId}")
    public void assignTagToTask(@PathVariable Long taskId, @PathVariable Long tagId) {
        taskTagService.assignTagToTask(taskId, tagId);
    }

    @DeleteMapping("/{tagId}")
    public void removeTagFromTask(@PathVariable Long taskId, @PathVariable Long tagId) {
        taskTagService.removeTagFromTask(taskId, tagId);
    }
}
