package com.cvbuilder.repositories;

import com.cvbuilder.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Find user by email
    Optional<User> findByEmail(String email);

    // Check if email exists (add this method)
    boolean existsByEmail(String email);
}