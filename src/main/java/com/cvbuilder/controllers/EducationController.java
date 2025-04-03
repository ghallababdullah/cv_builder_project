package com.cvbuilder.controllers;

import com.cvbuilder.entities.Education;
import com.cvbuilder.services.EducationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
public class EducationController {

    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    // Add education to a CV
    @PostMapping
    public ResponseEntity<Education> addEducation(
            @RequestBody Education education,
            @RequestParam Long cvId
    ) {
        Education savedEducation = educationService.addEducation(education, cvId);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEducation);
    }
    @GetMapping("/cv/{cvId}")
    public List<Education> getEducations(@PathVariable Long cvId) {
        return educationService.getEducationsByCV(cvId);
    }

    // Delete education entry
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long id) {
        educationService.deleteEducation(id);
        return ResponseEntity.noContent().build();
    }
}