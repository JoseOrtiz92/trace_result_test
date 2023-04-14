package com.example.traceresult.controller;

import com.example.traceresult.model.dto.TracerDTO;
import com.example.traceresult.service.TracerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TracerResultController.class)
class TracerServiceResultControllerTest {

    @SpyBean
    private TracerResultController tracerResultController;

    @MockBean
    private TracerService tracerService;

    @Test
    void getTracer() {
        TracerDTO responseDTO = TracerDTO.builder().response("test").build();
        when(tracerService.trace(any(BigDecimal.class))).thenReturn(responseDTO);

        ResponseEntity<TracerDTO> response = tracerResultController.getTracer(BigDecimal.TEN);

        assertNotNull(response);
        assertEquals(responseDTO.getResponse(), response.getBody().getResponse());
    }
}