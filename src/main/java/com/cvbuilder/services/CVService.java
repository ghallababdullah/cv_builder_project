package com.cvbuilder.services;

import com.cvbuilder.entities.CV;
import com.cvbuilder.entities.User;
import com.cvbuilder.Repositories.CVRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.cvbuilder.exceptions.InvalidDataException;
import com.cvbuilder.exceptions.NotFoundException;
@Service
@Transactional
public class CVService {

    private final CVRepository cvRepository;
    private final UserService userService;

    public CVService(CVRepository cvRepository, UserService userService) {
        this.cvRepository = cvRepository;
        this.userService = userService;
    }

    public CV createCV(CV cv, Long userId) {
        // Validation
        if (cv.getName() == null || cv.getName().isBlank()) {
            throw new InvalidDataException("CV name is required");
        }

        User user = userService.getUserById(userId); // Throws NotFoundException
        cv.setUser(user);
        return cvRepository.save(cv);
    }
    public CV getCVById(Long cvId) {
        return cvRepository.findById(cvId)
                .orElseThrow(() -> new NotFoundException("CV not found with ID: " + cvId));
    }

    public List<CV> getUserCVs(Long userId) {
        return cvRepository.findByUserId(userId);
    }
}