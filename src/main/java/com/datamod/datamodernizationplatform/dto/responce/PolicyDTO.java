package com.datamod.datamodernizationplatform.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyDTO {

    private Long id;
    private String policyNumber;
    private String type;
    private String status;
    private String customerId;  // To avoid circular DTOs (matches Customer.id)
}