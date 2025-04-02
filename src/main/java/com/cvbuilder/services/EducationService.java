package com.cvbuilder.services;

import com.cvbuilder.entities.Education;
import com.cvbuilder.entities.CV;
import com.cvbuilder.repositories.EducationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.cvbuilder.exceptions.InvalidDataException;
import com.cvbuilder.exceptions.NotFoundException;

@Service
@Transactional
public class EducationService {

    private final EducationRepository educationRepository;
    private final CVService cvService;

    public EducationService(EducationRepository educationRepository, CVService cvService) {
        this.educationRepository = educationRepository;
        this.cvService = cvService;
    }

    public Education addEducation(Education education, Long cvId) {
        // Validation
        if (education.getDegree() == null || education.getDegree().isBlank()) {
            throw new InvalidDataException("Degree is required");
        }
        if (education.getUniversity() == null || education.getUniversity().isBlank()) {
            throw new InvalidDataException("University is required");
        }

        CV cv = cvService.getCVById(cvId); // Throws NotFoundException
        education.setCv(cv);
        return educationRepository.save(education);
    }
    public List<Education> getEducationById (Long cvId){
        return educationRepository.findByCvId(cvId);

    }

    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }
}