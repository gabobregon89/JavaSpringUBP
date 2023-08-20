package com.spring.ubp.JavaSpringUBP.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@Getter
public class SpotifyConfig {

    @Value("${token_spotify_access}")
    private String apiToken;

    @Value("${base_url_search}")
    private String baseUrl;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}
