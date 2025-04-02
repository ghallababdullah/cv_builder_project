package com.cvbuilder.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class CV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String summary;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Each CV belongs to a user

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
    private List<Education> educations;  // CV has multiple education entries

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
    private List<WorkExperience> workExperiences;

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
    private List<Skill> skills;

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
    private List<Project> projects;

    @ManyToOne
    @JoinColumn(name = "template_id")
    private Template template;  // CV uses a design template
}