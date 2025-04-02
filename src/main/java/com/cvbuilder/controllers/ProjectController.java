package com.cvbuilder.controllers;

import com.cvbuilder.entities.Project;
import com.cvbuilder.services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<Project> addProject(
            @RequestBody Project project,
            @RequestParam Long cvId
    ) {
        Project savedProject = projectService.addProject(project, cvId);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProject);
    }
}