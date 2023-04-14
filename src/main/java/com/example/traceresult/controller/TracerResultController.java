package com.example.traceresult.controller;

import com.example.traceresult.model.dto.ErrorResponse;
import com.example.traceresult.model.dto.TracerDTO;
import com.example.traceresult.service.TracerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * The type Tracer result controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "v1")
public class TracerResultController {

    /**
     * The Tracer service.
     */
    @Autowired
    public TracerService tracerService;

    /**
     * Trace result.
     *
     * @param result the result
     * @return TracerDTO
     */
    @Operation(description = "Endpoint para tracear un resultado",
            summary = "Tracea un resultado",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "BAD_REQUEST",
                            responseCode = "400",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))
                    ),
                    @ApiResponse(
                            description = "NOT_FOUND",
                            responseCode = "404",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))
                    ),
                    @ApiResponse(
                            description = "INTERNAL_SERVER_ERROR",
                            responseCode = "500",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))
                    )
            })
    @GetMapping(value = "/trace-result")
    public ResponseEntity<TracerDTO> getTracer(
            @RequestParam(value = "result") BigDecimal result
    ){
        TracerDTO response = tracerService.trace(result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
