package com.cvbuilder.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String previewImageUrl;  // Path to template thumbnail

    @OneToMany(mappedBy = "template")
    private List<CV> cvs;  // One template can be used by many CVs
}