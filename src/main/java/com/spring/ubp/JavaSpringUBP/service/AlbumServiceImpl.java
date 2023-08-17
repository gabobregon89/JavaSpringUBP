package com.spring.ubp.JavaSpringUBP.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.ubp.JavaSpringUBP.configuration.SpotifyConfig;
import com.spring.ubp.JavaSpringUBP.model.Album;
import com.spring.ubp.JavaSpringUBP.model.Album2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    private SpotifyConfig spotifyConfig;

    @Autowired
    private RestTemplate restTemplate;

    private final String URL_BASE = "https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy";

    @Override
//    public Album2 getAllAlbums() {
//
//    }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("Authorization", "Bearer BQAMpbhGUb2K_ftZYbaqKjTSuNk8lB-E170G8l9gs8S07T5LLbLwVikMmXtSiZf0Gl_SzHxBFZF1l3DJ70-VLFWkD6NojvhIQaJ0AaQAMLDt34pOYSI");
//
//        Album2 response = restTemplate.getForObject(URL_BASE, Album2.class);
//
//
//        return response;
//    }
    public Album2 getAllAlbums() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
            String token = "Bearer " + spotifyConfig.getApiToken();
            headers.set("Authorization", token);

            ResponseEntity<String> response = restTemplate.exchange(URL_BASE, HttpMethod.GET, new HttpEntity<>(headers), String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                String responseBody = response.getBody();

                ObjectMapper objectMapper = new ObjectMapper();
                Album2 albumResponse = objectMapper.readValue(responseBody, Album2.class);

                return albumResponse;
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
