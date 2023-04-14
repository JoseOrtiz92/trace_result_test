package com.example.traceresult.service.impl;


import com.example.traceresult.model.dto.TracerDTO;
import com.example.traceresult.service.Tracer;
import com.example.traceresult.util.Constants;
import org.springframework.stereotype.Service;

/**
 * Implementación por defecto de Tracer - no es especialmente brillante, pero para la realización de la POC es más que de sobra.
 */
@Service
public class TracerImpl implements Tracer {

    @Override
    public <T> TracerDTO trace(final T result ) {
        return TracerDTO.builder().response(Constants.RESULT.concat(result.toString())).build();
    }

}
