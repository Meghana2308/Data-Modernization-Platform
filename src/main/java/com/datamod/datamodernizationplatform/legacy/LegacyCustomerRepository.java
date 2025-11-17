package com.datamod.datamodernizationplatform.legacy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.datamod.datamodernizationplatform.dto.CustomerDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LegacyCustomerRepository {

    private final LegacyDataLoader loader;

    public List<CustomerDTO> findAll() {
        JsonNode customers = loader.getNode("customers");
        ObjectMapper mapper = new ObjectMapper();

        return mapper.convertValue(
                customers,
                new TypeReference<List<CustomerDTO>>() {}
        );
    }
}
