package com.example.service;

import com.example.model.RoleApp;
import com.example.model.UserGroupRole;
import com.example.model.UserGroupRoleId;
import com.example.repository.UserGroupRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserGroupRoleService {

    private final UserGroupRoleRepository userGroupRoleRepository;

    public void assingRoleToUser(Long userId, Long groupId, RoleApp role) {
        UserGroupRoleId userGroupRoleId = new UserGroupRoleId(userId, groupId);
        UserGroupRole userGroupRole = new UserGroupRole(userGroupRoleId, role);
        userGroupRoleRepository.save(userGroupRole);
    }

    public RoleApp getRole(Long userId, Long groupId) {
        return userGroupRoleRepository.findByIdUserIdAndIdGroupId(userId, groupId).getRole();
    }

    public void removeUserFromGroup(Long userId, Long groupId) {
        UserGroupRoleId id = new UserGroupRoleId(groupId, userId);
        System.out.println("UGR para eliminar: " + id);
        userGroupRoleRepository.deleteById(id);
    }

    public List<UserGroupRole> getUsersInGroup(Long groupId) {
        return userGroupRoleRepository.findByIdGroupId(groupId);
    }
}
