package com.example.controller;

import com.example.model.RoleApp;
import com.example.service.RoleAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleAppController {

    private final RoleAppService roleAppService;

    @GetMapping
    public List<RoleApp> getAllRoles() {
        return roleAppService.getAllRoles();
    }

    @GetMapping("/{roleId}")
    public RoleApp getRoleById(@PathVariable Long roleId) {
        return roleAppService.getRoleById(roleId);
    }

    @PostMapping
    public RoleApp createRole(@RequestBody RoleApp roleApp) {
        return roleAppService.createRole(roleApp);
    }

    @PutMapping("/{roleId}")
    public RoleApp updateRole(@PathVariable Long roleId, @RequestBody RoleApp roleApp) {
        return roleAppService.updateRole(roleId, roleApp);
    }

    @DeleteMapping("/{roleId}")
    public void deleteRole(@PathVariable Long roleId) {
        roleAppService.deleteRole(roleId);
    }
}
