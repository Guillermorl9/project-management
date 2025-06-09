package com.example.service;

import com.example.model.TaskGroup;
import com.example.model.TaskGroupId;
import com.example.repository.TaskGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskGroupService {

    private final TaskGroupRepository taskGroupRepository;

    public void assignGroupToTask(Long taskId, Long groupId) {
        TaskGroupId taskGroupId = new TaskGroupId(taskId, groupId);
        TaskGroup taskGroup = new TaskGroup(taskGroupId);
        taskGroupRepository.save(taskGroup);
    }

    public void removeGroupFromTask(Long taskId, Long groupId) {
        TaskGroupId taskGroupId = new TaskGroupId(taskId, groupId);
        taskGroupRepository.deleteById(taskGroupId);
    }

    public List<TaskGroup> getGroupsByTaskId(Long taskId) {
        return taskGroupRepository.findByIdTaskId(taskId);
    }
}
