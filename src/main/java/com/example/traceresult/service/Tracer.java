package com.example.traceresult.service;

import com.example.traceresult.model.dto.TracerDTO;

public interface Tracer {
    public <T> TracerDTO trace(final T result );
}
