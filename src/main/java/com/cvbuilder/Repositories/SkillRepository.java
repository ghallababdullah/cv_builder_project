package com.cvbuilder.repositories;

import com.cvbuilder.entities.Skill;
import com.cvbuilder.entities.CV;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findByCv(CV cv);
    List<Skill> findByCvId(Long cvId);
    void deleteByCvId(Long cvId);
}