package com.spring.ubp.JavaSpringUBP.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.ubp.JavaSpringUBP.configuration.SpotifyConfig;
import com.spring.ubp.JavaSpringUBP.dto.spotify.CompleteSpotify;
import com.spring.ubp.JavaSpringUBP.dto.spotify.ItemsTrack;
import com.spring.ubp.JavaSpringUBP.dto.spotify.TrackResponse;
import com.spring.ubp.JavaSpringUBP.dto.spotify.TracksSpotify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class SpotifyServiceImpl implements SpotifyService {

    @Autowired
    private SpotifyConfig spotifyConfig;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public TracksSpotify getTracksByArtist(String name) throws JsonProcessingException {
        CompleteSpotify complete = searchToSpotify(name);
        return complete.getTracks();
    }

    @Override
    public TrackResponse getTrack(String track) throws JsonProcessingException {
        CompleteSpotify complete = searchToSpotify(track);
        ItemsTrack item = complete.getTracks().getItems().get(0);
        TrackResponse trackResponse = new TrackResponse();
        trackResponse.setSpotifyId(item.getId());
        trackResponse.setName(item.getName());
        trackResponse.setDurationMs(item.getDuration_ms());
        trackResponse.setArtist(complete.getArtists().getItems().get(0).getName());
        return trackResponse;
    }

    public CompleteSpotify searchToSpotify(String condition) throws JsonProcessingException {
        CompleteSpotify complete = new CompleteSpotify();
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
            String token = "Bearer " + spotifyConfig.getApiToken();
            headers.set("Authorization", token);
            String endpoint = spotifyConfig.getBaseUrl();
            endpoint = endpoint.replace("{NAME}", condition);

            ResponseEntity<String> response = restTemplate.exchange(endpoint, HttpMethod.GET, new HttpEntity<>(headers), String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                String responseBody = response.getBody();

                ObjectMapper objectMapper = new ObjectMapper();
                complete = objectMapper.readValue(responseBody, CompleteSpotify.class);

                return complete;
            } else {
                // Manejo de posibles códigos de estado de error aquí
                return complete;
            }
        } catch (RestClientException | JsonProcessingException e) {
            throw e;
        }
    }
}
