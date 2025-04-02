package com.cvbuilder.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String degree;
    private String university;
    private String startDate;
    private String endDate;
    private String description;

    @ManyToOne
    @JoinColumn(name = "cv_id", nullable = false)
    private CV cv;  // Each education entry belongs to a CV
}