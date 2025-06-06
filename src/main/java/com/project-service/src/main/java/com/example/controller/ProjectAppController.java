package com.example.controller;

import com.example.model.ProjectApp;
import com.example.service.ProjectAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectAppController {

    private final ProjectAppService projectAppService;

    @GetMapping
    public List<ProjectApp> getAllProjects() {
        return projectAppService.getAllProjects();
    }

    @GetMapping("/{projectId}")
    public ProjectApp getProjectById(@PathVariable Long projectId) {
        return projectAppService.getProjectById(projectId);
    }

    @PostMapping
    public ProjectApp createProject(@RequestBody ProjectApp projectApp) {
        return projectAppService.createProject(projectApp);
    }

    @PutMapping("/{projectId}")
    public ProjectApp updateProject(@PathVariable Long projectId, @RequestBody ProjectApp projectApp) {
        return projectAppService.updateProject(projectId, projectApp);
    }

    @DeleteMapping("/{projectId}")
    public void deleteProject(@PathVariable Long projectId) {
        projectAppService.deleteProject(projectId);
    }
}
