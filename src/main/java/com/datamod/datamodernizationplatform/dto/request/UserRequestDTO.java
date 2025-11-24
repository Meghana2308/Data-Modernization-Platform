package com.datamod.datamodernizationplatform.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDTO {

    @Schema(description = "User first name", example = "John")
    @NotBlank
    private String firstName;

    @Schema(description = "User last name", example = "Doe")
    private String lastName;

    @Schema(description = "Valid email address", example = "john.doe@company.com")
    @Email
    private String email;

    @Schema(description = "User age", example = "28")
    @Min(18)
    private int age;
}

