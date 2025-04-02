package com.cvbuilder.controllers;

import com.cvbuilder.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test-tables")
    public String testTables() {
        // This will trigger table creation if tables don't exist
        userRepository.count();
        return "Checked tables! If they didn't exist, they were created.";
    }
}