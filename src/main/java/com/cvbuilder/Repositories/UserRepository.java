package com.cvbuilder.Repositories;

import com.cvbuilder.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Find user by email
    Optional<User> findByEmail(String email);

    // Check if email exists (add this method)
    boolean existsByEmail(String email);
}