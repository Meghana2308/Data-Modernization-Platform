package com.datamod.datamodernizationplatform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgentDTO {

    private Long id;
    private String agentCode;
    private String name;
}
