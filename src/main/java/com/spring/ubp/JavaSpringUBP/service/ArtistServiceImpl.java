package com.spring.ubp.JavaSpringUBP.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.ubp.JavaSpringUBP.configuration.SpotifyConfig;
import com.spring.ubp.JavaSpringUBP.dto.spotify.CompleteSpotify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private SpotifyConfig spotifyConfig;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CompleteSpotify getArtistByName(String name) {

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
            String token = "Bearer " + spotifyConfig.getApiToken();
            headers.set("Authorization", token);
            String endpoint = spotifyConfig.getBaseUrl();
            endpoint = endpoint.replace("{NAME}", name);

            ResponseEntity<String> response = restTemplate.exchange(endpoint, HttpMethod.GET, new HttpEntity<>(headers), String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                String responseBody = response.getBody();

                ObjectMapper objectMapper = new ObjectMapper();
                CompleteSpotify items = objectMapper.readValue(responseBody, CompleteSpotify.class);

                return items;
            } else {
                // Manejo de posibles códigos de estado de error aquí
                return null;
            }
        } catch (Exception e) {
            // Manejo de excepciones aquí
            return null;
        }
    }
}
