package com.cvbuilder.repositories;

import com.cvbuilder.entities.WorkExperience;
import com.cvbuilder.entities.CV;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long> {
    List<WorkExperience> findByCv(CV cv);
    List<WorkExperience> findByCvId(Long cvId);
    void deleteByCvId(Long cvId);
}