package com.datamod.datamodernizationplatform.controller;

import com.datamod.datamodernizationplatform.dto.request.UserRequestDTO;
import com.datamod.datamodernizationplatform.dto.responce.UserResponseDTO;
import com.datamod.datamodernizationplatform.exceptions.ApiError;
import com.datamod.datamodernizationplatform.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@Tag(
        name = "User Management",
        description = "Operations related to managing users in the system"
)
public class UserController {
    @Autowired
    private UserService service;

    @Operation(
            summary = "Create a new user",
            description = "This API creates a new user with provided details."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created successfully",
                    content = @Content(schema = @Schema(implementation = UserResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Validation error",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "409", description = "Email already exists")
    })
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(
            @Valid @RequestBody UserRequestDTO request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.createUser(request));
    }

}

