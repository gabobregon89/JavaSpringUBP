package com.spring.ubp.JavaSpringUBP.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.ubp.JavaSpringUBP.configuration.SpotifyConfig;
import com.spring.ubp.JavaSpringUBP.dto.spotify.TracksSpotify;
import com.spring.ubp.JavaSpringUBP.utils.Consts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class SpotifyServiceImplTest {

    SpotifyServiceImpl spotifyService;

    SpotifyConfig spotifyConfig = mock(SpotifyConfig.class);

    RestTemplate restTemplate = mock(RestTemplate.class);;

    @BeforeEach
    void setUp() {
        spotifyService = new SpotifyServiceImpl();
        ReflectionTestUtils.setField(spotifyService, "spotifyConfig", spotifyConfig);
        ReflectionTestUtils.setField(spotifyService, "restTemplate", restTemplate);
    }

    @Test
    void getTracksByArtist() throws JsonProcessingException {
        ResponseEntity<String> stringTracks = ResponseEntity.ok(Consts.JSON_ITEMS);

        when(spotifyConfig.getApiToken()).thenReturn(Consts.SPOTIFY_TOKEN);
        when(spotifyConfig.getBaseUrl()).thenReturn(Consts.URL_BASE);
        when(restTemplate.exchange(
                anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(String.class)
                )
        ).thenReturn(stringTracks);

        TracksSpotify response = spotifyService.getTracksByArtist(Consts.ARTIST);

        assertNotNull(response);
        assertEquals(1, response.getItems().size());
        assertEquals("Salvame", response.getItems().get(0).getName());
    }

    @Test
    void getTrack() {
    }
}