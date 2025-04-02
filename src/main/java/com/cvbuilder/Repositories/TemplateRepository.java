package com.cvbuilder.Repositories;

import com.cvbuilder.entities.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TemplateRepository extends JpaRepository<Template, Long> {
    // Exact name match
    Optional<Template> findByName(String name);

    // Case-insensitive search
    List<Template> findByNameContainingIgnoreCase(String keyword);

    // Top 5 popular templates
    @Query("SELECT t FROM Template t ORDER BY t.downloadCount DESC LIMIT 5")
    List<Template> findTop5Popular();
}