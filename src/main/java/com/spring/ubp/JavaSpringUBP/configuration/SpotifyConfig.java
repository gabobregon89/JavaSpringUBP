package com.spring.ubp.JavaSpringUBP.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class SpotifyConfig {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
