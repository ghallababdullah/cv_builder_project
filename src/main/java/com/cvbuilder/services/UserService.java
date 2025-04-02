package com.cvbuilder.services;

import com.cvbuilder.entities.User;
import com.cvbuilder.Repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cvbuilder.exceptions.InvalidDataException;
import com.cvbuilder.exceptions.NotFoundException;
import com.cvbuilder.exceptions.AlreadyExistsException;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        // Validation

        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidDataException("Email is required");
        }
        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new InvalidDataException("Password is required");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new AlreadyExistsException("Email already registered");
        }

        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }
}