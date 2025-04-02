package com.cvbuilder.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String proficiency;  // e.g., "Beginner", "Expert"

    @ManyToOne
    @JoinColumn(name = "cv_id", nullable = false)
    private CV cv;
}