package com.example.traceresult.service.impl;

import com.example.traceresult.model.dto.TracerDTO;
import com.example.traceresult.service.TracerService;
import com.example.traceresult.util.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TracerServiceImpl.class)
class TracerServiceImplTest {

    @SpyBean
    private TracerService tracerService;

    @Test
    void trace() {
        TracerDTO response = tracerService.trace(BigDecimal.TEN);

        assertNotNull(response);
        assertEquals(response.getResponse(), Constants.RESULT.concat(BigDecimal.TEN.toString()));
    }
}