package com.cvbuilder.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class WorkExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;
    private String position;
    private String startDate;
    private String endDate;
    private String description;

    @ManyToOne
    @JoinColumn(name = "cv_id", nullable = false)
    private CV cv;
}