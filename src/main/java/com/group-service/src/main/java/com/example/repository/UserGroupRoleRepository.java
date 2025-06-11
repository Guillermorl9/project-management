package com.example.repository;

import com.example.model.UserGroupRole;
import com.example.model.UserGroupRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserGroupRoleRepository extends JpaRepository<UserGroupRole, UserGroupRoleId> {

    List<UserGroupRole> findByIdUserId(Long userId);
    List<UserGroupRole> findByIdGroupId(Long groupId);
    UserGroupRole findByIdUserIdAndIdGroupId(Long userId, Long groupId);
}
