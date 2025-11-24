package com.datamod.datamodernizationplatform.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgentRequestDTO {

    @NotBlank(message = "Agent code is required")
    private String agentCode;

    @NotBlank(message = "Agent name is required")
    private String name;
}