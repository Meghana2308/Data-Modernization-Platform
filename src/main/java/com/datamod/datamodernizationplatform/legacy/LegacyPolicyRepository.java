package com.datamod.datamodernizationplatform.legacy;

import com.datamod.datamodernizationplatform.dto.PolicyDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class LegacyPolicyRepository {

    private final LegacyDataLoader loader;

    public List<PolicyDTO> findAll() {
        JsonNode policy = loader.getNode("policy");
        ObjectMapper mapper = new ObjectMapper();

        return mapper.convertValue(
                policy,
                new TypeReference<List<PolicyDTO>>() {}
        );
    }
}
