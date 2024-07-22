package com.hackathonteam2.recomovie.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class TMDBConfig {

    @Value("${base_url}")
    private String baseURL;

    @Value("${secret_key}")
    private String secretKey;

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl(baseURL)
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.set("Accept", "application/json");
                    httpHeaders.set("Authorization", "Bearer " + secretKey);
                })
                .build();
    }
}
