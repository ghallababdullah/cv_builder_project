package com.cvbuilder.services;

import com.cvbuilder.entities.WorkExperience;
import com.cvbuilder.entities.CV;
import com.cvbuilder.repositories.WorkExperienceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cvbuilder.exceptions.InvalidDataException;
import java.util.List;
@Service
@Transactional
public class WorkExperienceService {
    private final WorkExperienceRepository workExperienceRepository;
    private final CVService cvService;
    public WorkExperienceService(WorkExperienceRepository workExperienceRepository,
                                 CVService cvService) {
        this.workExperienceRepository = workExperienceRepository;
        this.cvService = cvService;
    }
    public WorkExperience addWorkExperience(WorkExperience workExperience, Long cvId) {
        // Validation
        if (workExperience.getCompany() == null || workExperience.getCompany().isBlank()) {
            throw new InvalidDataException("Company name is required");
        }
        if (workExperience.getPosition() == null || workExperience.getPosition().isBlank()) {
            throw new InvalidDataException("Position is required");
        }

        CV cv = cvService.getCVById(cvId); // Throws NotFoundException
        workExperience.setCv(cv);
        return workExperienceRepository.save(workExperience);
    }

    public List<WorkExperience> getWorkExperiencesByCvId(Long cvId) {
        return workExperienceRepository.findByCvId(cvId);
    }

    public void deleteWorkExperience(Long id) {
        workExperienceRepository.deleteById(id);
    }
    }











