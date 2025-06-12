package com.example.controller;

import com.example.model.TaskApp;
import com.example.service.TaskAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskAppService taskAppService;

    @GetMapping
    public List<TaskApp> getAllTasks() {
        return taskAppService.getAllTasks();
    }

    @GetMapping("/project/{projectId}")
    public List<TaskApp> getTasksByProjectId(@PathVariable String projectId) {
        return taskAppService.getTasksByProjectId(projectId);
    }

    @GetMapping("/{taskId}")
    public TaskApp getTaskById(@PathVariable Long taskId) {
        return taskAppService.getTaskById(taskId);
    }

    @PostMapping
    public TaskApp createTask(@RequestBody TaskApp taskApp) {
        System.out.println("Petición recibida: " + taskApp);
        return taskAppService.createTask(taskApp);
    }

    @PutMapping("/{taskId}")
    public TaskApp updateTask(@PathVariable Long taskId, @RequestBody TaskApp taskApp) {
        return taskAppService.updateTask(taskId, taskApp);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskAppService.deleteTask(taskId);
    }
}
