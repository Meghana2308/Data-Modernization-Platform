package com.datamod.datamodernizationplatform.dto.responce;

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
