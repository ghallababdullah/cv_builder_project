package com.cvbuilder.controllers;

import com.cvbuilder.entities.WorkExperience;
import com.cvbuilder.services.WorkExperienceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/work-experiences")
public class WorkExperienceController {

    private final WorkExperienceService workExperienceService;

    public WorkExperienceController(WorkExperienceService workExperienceService) {
        this.workExperienceService = workExperienceService;
    }

    @PostMapping
    public ResponseEntity<WorkExperience> addWorkExperience(
            @RequestBody WorkExperience workExperience,
            @RequestParam Long cvId
    ) {
        WorkExperience savedWE = workExperienceService.addWorkExperience(workExperience, cvId);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedWE);
    }
}