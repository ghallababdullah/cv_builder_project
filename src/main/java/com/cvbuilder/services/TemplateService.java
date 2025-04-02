package com.cvbuilder.services;

import com.cvbuilder.entities.Template;
import com.cvbuilder.repositories.TemplateRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cvbuilder.exceptions.InvalidDataException;
import com.cvbuilder.exceptions.NotFoundException;
import com.cvbuilder.exceptions.AlreadyExistsException;
import java.util.List;

@Service
@Transactional
public class TemplateService {

    private final TemplateRepository templateRepository;

    public TemplateService(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public Template createTemplate(Template template) {
        // Validation
        if (template.getName() == null || template.getName().isBlank()) {
            throw new InvalidDataException("Template name is required");
        }
        if (template.getPreviewImageUrl() == null || template.getPreviewImageUrl().isBlank()) {
            throw new InvalidDataException("Preview image URL is required");
        }

        return templateRepository.save(template);
    }

    public List<Template> getAllTemplates() {
        return templateRepository.findAll();
    }

    public Template getTemplateById(Long id) {
        return templateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Template not found"));
    }
}