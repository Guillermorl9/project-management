package com.example.controller;

import com.example.model.GroupApp;
import com.example.service.GroupAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupAppController {

    private final GroupAppService groupAppService;

    @GetMapping
    public List<GroupApp> getAllGroups() {
        return groupAppService.getAllGroups();
    }

    @GetMapping("/{groupId}")
    public GroupApp getGroupById(@PathVariable Long groupId) {
        return groupAppService.getGroupById(groupId);
    }

    @PostMapping
    public GroupApp createGroup(@RequestBody GroupApp groupApp) {
        return groupAppService.createGroup(groupApp);
    }

    @PutMapping("/{groupId}")
    public GroupApp updateGroup(@PathVariable Long groupId, @RequestBody GroupApp groupApp) {
        return groupAppService.updateGroup(groupId, groupApp);
    }

    @DeleteMapping("/{groupId}")
    public void deleteGroup(@PathVariable Long groupId) {
        groupAppService.deleteGroup(groupId);
    }

}
