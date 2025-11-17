package com.datamod.datamodernizationplatform.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PolicyRequestDTO {

    @NotBlank(message = "Policy number is required")
    private String policyNumber;

    @NotBlank(message = "Policy type is required")
    private String type;

    @NotBlank(message = "Policy status is required")
    private String status;

    private Long customerId;
}
