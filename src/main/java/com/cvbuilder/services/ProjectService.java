package com.cvbuilder.services;

import com.cvbuilder.entities.Project;
import com.cvbuilder.entities.CV;
import com.cvbuilder.Repositories.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.cvbuilder.exceptions.InvalidDataException;
import com.cvbuilder.exceptions.NotFoundException;
import com.cvbuilder.exceptions.AlreadyExistsException;
@Service
@Transactional
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final CVService cvService;

    public ProjectService(ProjectRepository projectRepository,
                          CVService cvService) {
        this.projectRepository = projectRepository;
        this.cvService = cvService;
    }

    public Project addProject(Project project, Long cvId) {
        // Validation
        if (project.getName() == null || project.getName().isBlank()) {
            throw new InvalidDataException("Project name is required");
        }
        if (project.getDescription() == null || project.getDescription().isBlank()) {
            throw new InvalidDataException("Description is required");
        }

        CV cv = cvService.getCVById(cvId); // Throws NotFoundException
        project.setCv(cv);
        return projectRepository.save(project);
    }

    public List<Project> getProjectsByCvId(Long cvId) {
        return projectRepository.findByCvId(cvId);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}