package com.spring.ubp.JavaSpringUBP.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.ubp.JavaSpringUBP.configuration.SpotifyConfig;
import com.spring.ubp.JavaSpringUBP.dto.TodoDTO;
import com.spring.ubp.JavaSpringUBP.model.Album2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

@Service
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    private SpotifyConfig spotifyConfig;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ArtistServiceImpl artistService;

    private final String URL_BASE = "https://api.spotify.com/v1/albums/";

    @Override
    public Album2 getAllAlbums(String name) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
            String token = "Bearer " + spotifyConfig.getApiToken();
            headers.set("Authorization", token);

            TodoDTO items = artistService.getArtistByName(name);
            String endpoint = URL_BASE + items.getAlbums().getItems().get(0).getId();

            ResponseEntity<String> response = restTemplate.exchange(endpoint, HttpMethod.GET, new HttpEntity<>(headers), String.class);

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
