package com.example.service;

import com.example.model.ProjectApp;
import com.example.repository.ProjectAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectAppService {

    private final ProjectAppRepository projectAppRepository;

    public List<ProjectApp> getAllProjects() {
        return projectAppRepository.findAll();
    }

    public ProjectApp getProjectById(Long id) {
        return projectAppRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
    }

    public ProjectApp createProject(ProjectApp projectApp) {
        return projectAppRepository.save(projectApp);
    }

    public ProjectApp updateProject(Long projectId, ProjectApp projectApp) {
        ProjectApp existingProject = projectAppRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + projectId));

        existingProject.setTitle(projectApp.getTitle());
        existingProject.setDescription(projectApp.getDescription());
        existingProject.setStart_date(projectApp.getStart_date());

        return projectAppRepository.save(existingProject);
    }

    public void deleteProject(Long id) {
        projectAppRepository.deleteById(id);
    }
}
