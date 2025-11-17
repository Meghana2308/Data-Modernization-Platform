package com.datamod.datamodernizationplatform.legacy;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
@Slf4j
public class LegacyDataLoader {

    private JsonNode root;

    @PostConstruct
    public void load() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("legacy-data.json");

        try (InputStream inputStream = resource.getInputStream()) {
            root = mapper.readTree(inputStream);
            log.info("Legacy data loaded successfully");
        }
    }

    public JsonNode getNode(String key) {
        return root != null ? root.get(key) : null;
    }
}
