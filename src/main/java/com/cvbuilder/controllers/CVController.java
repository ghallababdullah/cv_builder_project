package com.cvbuilder.controllers;

import com.cvbuilder.entities.CV;
import com.cvbuilder.services.CVService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cvs")
public class CVController {

    private final CVService cvService;

    public CVController(CVService cvService) {
        this.cvService = cvService;
    }

    // Create a new CV for a user
    @PostMapping
    public ResponseEntity<CV> createCV(@RequestBody CV cv, @RequestParam Long userId) {
        CV createdCV = cvService.createCV(cv, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCV);
    }

    // Get all CVs for a user
    @GetMapping
    public ResponseEntity<List<CV>> getUserCVs(@RequestParam Long userId) {
        List<CV> cvs = cvService.getUserCVs(userId);
        return ResponseEntity.ok(cvs);
    }
}