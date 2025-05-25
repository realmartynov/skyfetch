package com.realmartynov.skyfetch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class EolConfig {

    @Bean
    public RestClient eolRestClient(RestClient.Builder builder) {
        return builder
                .baseUrl("https://projecteol.ru")
                .build();
    }
}
