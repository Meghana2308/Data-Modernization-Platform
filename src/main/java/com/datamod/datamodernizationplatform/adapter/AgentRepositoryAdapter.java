package com.datamod.datamodernizationplatform.adapter;

import com.datamod.datamodernizationplatform.dto.AgentDTO;
import com.datamod.datamodernizationplatform.legacy.LegacyAgentRepository;
import com.datamod.datamodernizationplatform.model.Agent;
import com.datamod.datamodernizationplatform.repository.AgentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AgentRepositoryAdapter {

    private final AgentRepository postgresRepo;
    private final LegacyAgentRepository legacyRepo;

    public List<AgentDTO> getAllAgents() {

        List<AgentDTO> legacyAgents = legacyRepo.findAll();

        List<AgentDTO> postgresAgents = postgresRepo.findAll()
                .stream()
                .map(this::toDto)
                .toList();

        return Stream.concat(legacyAgents.stream(), postgresAgents.stream())
                .toList();
    }

    private AgentDTO toDto(Agent agent) {
        return new AgentDTO(
                agent.getId(),
                agent.getAgentCode(),
                agent.getName()
        );
    }
}
