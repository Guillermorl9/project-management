package com.example.service;

import com.example.model.GroupApp;
import com.example.repository.GroupAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupAppService {

    private final GroupAppRepository groupAppRepository;

    public List<GroupApp> getAllGroups() {
        return groupAppRepository.findAll();
    }

    public GroupApp getGroupByTitle(String title) {
        return groupAppRepository.findByTitle(title);
    }

    public GroupApp getGroupById(Long id) {
        return groupAppRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found with id: " + id));
    }

    public GroupApp createGroup(GroupApp groupApp) {
        return groupAppRepository.save(groupApp);
    }

    public GroupApp updateGroup(Long groupId, GroupApp groupApp) {
        GroupApp existingGroup = groupAppRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found with id: " + groupId));

        existingGroup.setTitle(groupApp.getTitle());
        existingGroup.setProjectId(groupApp.getProjectId());

        return groupAppRepository.save(existingGroup);
    }

    public void deleteGroup(Long id) {
        groupAppRepository.deleteById(id);
    }
}
