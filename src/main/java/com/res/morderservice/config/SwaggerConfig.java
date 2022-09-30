package com.res.morderservice.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("Restaurant-Management")
                .packagesToScan("com.res.morderservice.controller")
                .pathsToMatch("/**")
                .build();
    }
}
