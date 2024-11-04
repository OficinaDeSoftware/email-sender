package com.ms.email.repositories;

import com.ms.email.models.PayloadModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PayloadRepository extends JpaRepository<PayloadModel, UUID> {
}
