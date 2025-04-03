package com.cvbuilder.services;

import com.cvbuilder.entities.Skill;
import com.cvbuilder.entities.CV;
import com.cvbuilder.repositories.SkillRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.cvbuilder.exceptions.InvalidDataException;

@Service
@Transactional
public class SkillService {

    private final SkillRepository skillRepository;
    private final CVService cvService;

    public SkillService(SkillRepository skillRepository,
                        CVService cvService) {
        this.skillRepository = skillRepository;
        this.cvService = cvService;
    }

    public Skill addSkill(Skill skill, Long cvId) {
        // Validation
        if (skill.getName() == null || skill.getName().isBlank()) {
            throw new InvalidDataException("Skill name is required");
        }
        if (skill.getProficiency() == null || skill.getProficiency().isBlank()) {
            throw new InvalidDataException("Proficiency level is required");
        }

        CV cv = cvService.getCVById(cvId); // Throws NotFoundException
        skill.setCv(cv);
        return skillRepository.save(skill);
    }

    public List<Skill> getSkillsByCvId(Long cvId) {
        return skillRepository.findByCvId(cvId);
    }

    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }
}