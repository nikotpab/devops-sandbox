package com.devops.project.devopssandbox.repository;

import com.devops.project.devopssandbox.entity.CalculationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculationRepository extends JpaRepository<CalculationRecord, Long> {

}
