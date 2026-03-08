package com.agarwood.components.doc;

import io.swagger.v3.oas.models.OpenAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class SpringDocConfig {

    private final DocProperties properties;

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(properties.getInfo())
                .externalDocs(properties.getExternalDocs());
    }
}
