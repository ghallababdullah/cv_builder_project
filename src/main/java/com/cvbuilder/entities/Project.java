package com.cvbuilder.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String technologiesUsed;

    @ManyToOne
    @JoinColumn(name = "cv_id", nullable = false)
    private CV cv;
}