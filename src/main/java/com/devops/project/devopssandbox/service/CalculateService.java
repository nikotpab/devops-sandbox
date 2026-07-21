package com.devops.project.devopssandbox.service;

import com.devops.project.devopssandbox.dto.CalculationDTO;
import com.devops.project.devopssandbox.entity.CalculationRecord;
import com.devops.project.devopssandbox.repository.CalculationRepository;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {

    private final CalculationRepository repository;

    public CalculateService(CalculationRepository repository) {
        this.repository = repository;
    }

    public double calculate(CalculationDTO req){
    double d = Math.pow(req.getX(),2) + Math.pow(req.getY(),2);
    double result = Math.sqrt(d);
    repository.save(new CalculationRecord(req.getX(),req.getY(),result));
    return result;
}
}
