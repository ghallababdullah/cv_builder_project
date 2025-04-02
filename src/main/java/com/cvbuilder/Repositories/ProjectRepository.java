package com.cvbuilder.Repositories;

import com.cvbuilder.entities.Project;
import com.cvbuilder.entities.CV;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByCv(CV cv);
    List<Project> findByCvId(Long cvId);
    void deleteByCvId(Long cvId);
}