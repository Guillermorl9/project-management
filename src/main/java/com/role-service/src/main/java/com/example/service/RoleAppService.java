package com.example.service;

import com.example.model.RoleApp;
import com.example.repository.RoleAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleAppService {

    private final RoleAppRepository roleAppRepository;

    public List<RoleApp> getAllRoles() {
        return roleAppRepository.findAll();
    }

    public RoleApp getRoleById(Long id) {
        return roleAppRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
    }

    public RoleApp createRole(RoleApp roleApp) {
        return roleAppRepository.save(roleApp);
    }

    public RoleApp updateRole(Long roleId, RoleApp roleApp) {
        RoleApp existingRole = roleAppRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + roleId));

        existingRole.setTitle(roleApp.getTitle());

        return roleAppRepository.save(existingRole);
    }

    public void deleteRole(Long id) {
        roleAppRepository.deleteById(id);
    }
}
