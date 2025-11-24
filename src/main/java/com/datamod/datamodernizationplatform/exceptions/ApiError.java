package com.datamod.datamodernizationplatform.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError {

    @Schema(description = "HTTP status code", example = "400")
    private int status;

    @Schema(description = "Error message", example = "Validation failed")
    private String message;

    @Schema(description = "Detailed error list for fields")
    private List<String> errors;

    @Schema(description = "Timestamp of exception")
    private LocalDateTime timestamp;
}

