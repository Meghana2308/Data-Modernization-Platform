package com.datamod.datamodernizationplatform.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI baseOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Data Modernization Platform API")
                        .description("Enterprise grade REST APIs for Data Modernization Platform  with versioning, security & validation.")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("IT Support Team")
                                .email("support@company.com")
                                .url("https://company.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Company API Documentation Portal")
                        .url("https://docs.company.com"));
    }
}

