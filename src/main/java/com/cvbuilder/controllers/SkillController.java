package com.cvbuilder.controllers;

import com.cvbuilder.entities.Skill;
import com.cvbuilder.services.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    public ResponseEntity<Skill> addSkill(
            @RequestBody Skill skill,
            @RequestParam Long cvId
    ) {
        Skill savedSkill = skillService.addSkill(skill, cvId);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSkill);
    }
}