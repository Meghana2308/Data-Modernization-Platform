package com.datamod.datamodernizationplatform.legacy;


import com.datamod.datamodernizationplatform.dto.responce.AgentDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LegacyAgentRepository {

    private final LegacyDataLoader loader;

    public List<AgentDTO> findAll() {
        JsonNode agents = loader.getNode("agents");
        ObjectMapper mapper = new ObjectMapper();

        return mapper.convertValue(
                agents,
                new TypeReference<List<AgentDTO>>() {}
        );
    }
}
