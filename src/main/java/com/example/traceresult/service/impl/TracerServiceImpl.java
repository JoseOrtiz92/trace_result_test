package com.example.traceresult.service.impl;


import com.example.traceresult.model.dto.TracerDTO;
import com.example.traceresult.service.TracerService;
import com.example.traceresult.util.Constants;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Implementación por defecto de Tracer - no es especialmente brillante, pero para la realización de la POC es más que de sobra.
 */
@Service
public class TracerServiceImpl implements TracerService {

    @Override
    public TracerDTO trace(final BigDecimal result ) {
        return TracerDTO.builder().response(Constants.RESULT.concat(result.toString())).build();
    }

}
