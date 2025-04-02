package com.cvbuilder.repositories;

import com.cvbuilder.entities.CV;
import com.cvbuilder.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.ArrayList;

public interface CVRepository extends JpaRepository<CV, Long> {
    // Custom query: Find all CVs for a specific user
    List<CV> findByUser(User user);
    List<CV> findByUserId(Long userId);
}