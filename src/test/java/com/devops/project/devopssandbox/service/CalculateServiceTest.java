package com.devops.project.devopssandbox.service;

import com.devops.project.devopssandbox.dto.CalculationDTO;
import com.devops.project.devopssandbox.entity.CalculationRecord;
import com.devops.project.devopssandbox.repository.CalculationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CalculateServiceTest {

    @Mock
    private CalculationRepository calculationRepository;

    @InjectMocks
    private CalculateService calculateService;

    @Test
    void calculateReturnsDistanceAndSavesRecord() {
        CalculationDTO req = new CalculationDTO();
        req.setX(3);
        req.setY(4);

        double result = calculateService.calculate(req);

        assertEquals(5.0, result);

        ArgumentCaptor<CalculationRecord> captor = ArgumentCaptor.forClass(CalculationRecord.class);
        verify(calculationRepository).save(captor.capture());
        CalculationRecord saved = captor.getValue();
        assertEquals(3, saved.getX());
        assertEquals(4, saved.getY());
        assertEquals(5.0, saved.getResult());
    }
}
