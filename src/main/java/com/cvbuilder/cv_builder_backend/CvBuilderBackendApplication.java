package com.cvbuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.cvbuilder.entities")  // Explicit entity scan
@EnableJpaRepositories("com.cvbuilder.repositories")  // Explicit repository scan
public class CvBuilderBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(CvBuilderBackendApplication.class, args);
	}
}