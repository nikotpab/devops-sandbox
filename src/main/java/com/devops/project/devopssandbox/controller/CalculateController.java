package com.devops.project.devopssandbox.controller;

import com.devops.project.devopssandbox.dto.CalculationDTO;
import com.devops.project.devopssandbox.service.CalculateService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("calculate/")
public class CalculateController {

    private final CalculateService service;

    public CalculateController(CalculateService service) {
        this.service = service;
    }

    @PostMapping("calc")
    public double calculate(@RequestBody CalculationDTO req){
        return this.service.calculate(req);
    }
}
