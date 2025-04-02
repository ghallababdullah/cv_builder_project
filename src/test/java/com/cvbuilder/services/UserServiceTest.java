// src/test/java/com/cvbuilder/services/UserServiceTest.java
package com.cvbuilder.services;

import com.cvbuilder.entities.User;
import com.cvbuilder.exceptions.AlreadyExistsException;
import com.cvbuilder.Repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void createUser_ValidData_ReturnsUser() {
        User user = new User("abdullah","test@example.com", "password123");
        when(userRepository.existsByEmail(any())).thenReturn(false);
        when(userRepository.save(any())).thenReturn(user);

        User savedUser = userService.createUser(user);
        assertEquals("test@example.com", savedUser.getEmail());
    }

    @Test
    void createUser_DuplicateEmail_ThrowsException() {
        User user = new User("abdullah","exists@example.com", "password123");
        when(userRepository.existsByEmail(any())).thenReturn(true);

        assertThrows(AlreadyExistsException.class, () -> userService.createUser(user));
    }
}