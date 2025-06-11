package com.example.controller;

import com.example.model.RoleApp;
import com.example.model.UserGroupRole;
import com.example.service.UserGroupRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups/{groupId}/users")
@RequiredArgsConstructor
public class UserGroupRoleController {

    private final UserGroupRoleService userGroupRoleService;

    @GetMapping
    public List<UserGroupRole> getAllUsersInGroup(@PathVariable Long groupId) {
        return userGroupRoleService.getUsersInGroup(groupId);
    }

    @GetMapping("/{userId}")
    public RoleApp getRole(@PathVariable Long groupId, @PathVariable Long userId) {
        return userGroupRoleService.getRole(groupId, userId);
    }

    @PostMapping("/{userId}/role")
    public void assignRoleToUser(@PathVariable Long groupId, @PathVariable Long userId, @RequestBody RoleApp roleApp) {
        userGroupRoleService.assingRoleToUser(userId, groupId, roleApp);
    }

    @DeleteMapping("/{userId}")
    public void removeUserFromGroup(@PathVariable Long groupId, @PathVariable Long userId) {
        System.out.println("GrupoID: " + groupId + ", UserID: " + userId);
        userGroupRoleService.removeUserFromGroup(groupId, userId);
    }
}
