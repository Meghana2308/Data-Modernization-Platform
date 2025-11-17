package com.datamod.datamodernizationplatform.adapter;

import com.datamod.datamodernizationplatform.dto.PolicyDTO;
import com.datamod.datamodernizationplatform.legacy.LegacyPolicyRepository;
import com.datamod.datamodernizationplatform.model.Policy;
import com.datamod.datamodernizationplatform.repository.PolicyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PolicyRepositoryAdapter {

    private final PolicyRepository postgresRepo;
    private final LegacyPolicyRepository legacyRepo;

    public List<PolicyDTO> getAllPolicies() {

        List<PolicyDTO> legacyPolicies = legacyRepo.findAll();

        List<PolicyDTO> postgresPolicies = postgresRepo.findAll()
                .stream()
                .map(this::toDto)
                .toList();

        return Stream.concat(legacyPolicies.stream(), postgresPolicies.stream())
                .toList();
    }

    private PolicyDTO toDto(Policy policy) {
        return new PolicyDTO(
                policy.getId(),
                policy.getPolicyNumber(),
                policy.getType(),
                policy.getStatus(),
                policy.getCustomer().getId()
        );
    }
}