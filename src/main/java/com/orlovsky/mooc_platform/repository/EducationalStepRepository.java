package com.orlovsky.mooc_platform.repository;

import com.orlovsky.mooc_platform.model.EducationalStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EducationalStepRepository extends JpaRepository<EducationalStep, UUID> {
}
