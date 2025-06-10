package com.example.service;

import com.example.model.TaskTag;
import com.example.model.TaskTagId;
import com.example.repository.TaskTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskTagService {

    private final TaskTagRepository taskTagRepository;

    public void assignTagToTask(Long taskId, Long tagId) {
        TaskTagId taskTagId = new TaskTagId(taskId, tagId);
        TaskTag taskTag = new TaskTag(taskTagId);
        taskTagRepository.save(taskTag);
    }

    public void removeTagFromTask(Long taskId, Long tagId) {
        TaskTagId taskTagId = new TaskTagId(taskId, tagId);
        taskTagRepository.deleteById(taskTagId);
    }

    public List<TaskTag> getTagsByTaskId(Long taskId) {
        return taskTagRepository.findByIdTaskId(taskId);
    }
}
