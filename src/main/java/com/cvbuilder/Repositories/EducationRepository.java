package com.cvbuilder.repositories;

import com.cvbuilder.entities.Education;
import com.cvbuilder.entities.CV;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {
    // Find all education entries for a CV
    List<Education> findByCv(CV cv);
    List<Education> findByCvId(Long cvId);
    void deleteByCvId(Long cvId);
}