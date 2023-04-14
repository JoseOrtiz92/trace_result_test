package com.example.traceresult.service;

import com.example.traceresult.model.dto.TracerDTO;

import java.math.BigDecimal;

/**
 * The interface Tracer service.
 */
public interface TracerService {

    /**
     * Trace response.
     *
     * @param result the result
     * @return the tracer dto
     */
    TracerDTO trace(final BigDecimal result );
}
