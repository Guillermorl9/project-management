package com.example.service;

import com.example.model.TaskApp;
import com.example.repository.TaskAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskAppService {

    private final TaskAppRepository taskAppRepository;

    public List<TaskApp> getAllTasks() {
        return taskAppRepository.findAll();
    }

    public List<TaskApp> getTasksByProjectId(String projectId) {
        return taskAppRepository.findAllByProjectId(projectId);
    }

    public TaskApp getTaskById(Long id) {
        return taskAppRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    public TaskApp createTask(TaskApp taskApp) {
        return taskAppRepository.save(taskApp);
    }

    public TaskApp updateTask(Long taskId, TaskApp taskApp) {
        TaskApp existingTask = taskAppRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + taskId));

        existingTask.setTitle(taskApp.getTitle());
        existingTask.setDescription(taskApp.getDescription());
        existingTask.setPriority(taskApp.getPriority());
        existingTask.setStatus(taskApp.getStatus());
        existingTask.setDue_date(taskApp.getDue_date());
        existingTask.setModified_by(taskApp.getModified_by());
        existingTask.setModified_date(taskApp.getModified_date());
        existingTask.setProjectId(taskApp.getProjectId());
        existingTask.setCreated_by(taskApp.getCreated_by());

        return taskAppRepository.save(existingTask);
    }

    public void deleteTask(Long id) {
        taskAppRepository.deleteById(id);
    }
}
