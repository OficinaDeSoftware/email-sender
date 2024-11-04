package com.ms.email.repositories;

import com.ms.email.models.TemplateModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TemplateRepository extends JpaRepository<TemplateModel, UUID> {
    Optional<TemplateModel> findByName( final String name );
}
