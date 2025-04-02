package com.cvbuilder.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String fullName;
    private int age ;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CV> cvs;  // One user can have multiple CVs
}