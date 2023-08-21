package com.spring.ubp.JavaSpringUBP.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.ubp.JavaSpringUBP.configuration.SpotifyConfig;
import com.spring.ubp.JavaSpringUBP.dto.TrackDTO;
import com.spring.ubp.JavaSpringUBP.dto.spotify.ItemsTrack;
import com.spring.ubp.JavaSpringUBP.dto.spotify.TrackResponse;
import com.spring.ubp.JavaSpringUBP.dto.spotify.TracksSpotify;
import com.spring.ubp.JavaSpringUBP.utils.Consts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("getTracksByArtist with status OK")
    void getTracksByArtist() throws JsonProcessingException {
        ResponseEntity<String> stringTracks = ResponseEntity.ok(Consts.JSON_COMPLETE);

        when(spotifyConfig.getApiToken()).thenReturn(Consts.SPOTIFY_TOKEN);
        when(spotifyConfig.getBaseUrl()).thenReturn(Consts.URL_BASE);
        when(restTemplate.exchange(
                anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(String.class)
                )
        ).thenReturn(stringTracks);

        TracksSpotify response = spotifyService.getTracksByArtist(Consts.ARTIST);

        ItemsTrack trackResponse = response.getItems().get(0);
        assertNotNull(response);
        assertEquals(1, response.getItems().size());
        assertEquals("laisjdolanmla23nb2kk3", trackResponse.getId());
        assertEquals("Salvame", trackResponse.getName());
        assertEquals(360000, trackResponse.getDuration_ms());
    }

    @Test
    @DisplayName("getTrack with status OK")
    void getTrack() throws JsonProcessingException {
        ResponseEntity<String> stringTracks = ResponseEntity.ok(Consts.JSON_COMPLETE);

        when(spotifyConfig.getApiToken()).thenReturn(Consts.SPOTIFY_TOKEN);
        when(spotifyConfig.getBaseUrl()).thenReturn(Consts.URL_BASE);
        when(restTemplate.exchange(
                anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(String.class)
                )
        ).thenReturn(stringTracks);

        TrackResponse response = spotifyService.getTrack(Consts.TRACK_NAME);

        assertNotNull(response);
        assertEquals("laisjdolanmla23nb2kk3", response.getSpotifyId());
        assertEquals("Salvame", response.getName());
        assertEquals(360000, response.getDurationMs());
        assertEquals("Los Cafres", response.getArtist());
    }

    @Test
    @DisplayName("getTrack with status not OK")
    void getTrackDistinctOK() {
        ResponseEntity<String> stringTracks = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        when(spotifyConfig.getApiToken()).thenReturn(Consts.SPOTIFY_TOKEN);
        when(spotifyConfig.getBaseUrl()).thenReturn(Consts.URL_BASE);
        when(restTemplate.exchange(
                anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(String.class)
                )
        ).thenReturn(stringTracks);

        Exception exception = assertThrows(NullPointerException.class, ()-> {
            spotifyService.getTrack(Consts.TRACK_NAME);
        });
        String message = exception.getMessage();

        assertNotNull(exception);
        assertEquals(message, exception.getMessage());
    }

    @Test
    @DisplayName("getTrack with response of restTemplate null")
    void getTrackResponseRestTemplateNull() {
        ResponseEntity<String> stringTracks = new ResponseEntity<>(null, HttpStatus.OK);

        when(spotifyConfig.getApiToken()).thenReturn(Consts.SPOTIFY_TOKEN);
        when(spotifyConfig.getBaseUrl()).thenReturn(Consts.URL_BASE);
        when(restTemplate.exchange(
                anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(String.class)
                )
        ).thenReturn(stringTracks);

        Exception exception = assertThrows(NullPointerException.class, ()-> {
            spotifyService.getTrack(Consts.TRACK_NAME);
        });
        String message = exception.getMessage();

        assertNotNull(exception);
        assertEquals(message, exception.getMessage());
    }

    @Test
    @DisplayName("getTrack with response json not compatible")
    void getTrackStringJsonResponseIncompatible() throws JsonProcessingException {
        ResponseEntity<String> stringTracks = new ResponseEntity<>(Consts.JSON_FALSE, HttpStatus.OK);

        when(spotifyConfig.getApiToken()).thenReturn(Consts.SPOTIFY_TOKEN);
        when(spotifyConfig.getBaseUrl()).thenReturn(Consts.URL_BASE);
        when(restTemplate.exchange(
                anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(String.class)
                )
        ).thenReturn(stringTracks);

        Exception exception = assertThrows(JsonProcessingException.class, ()-> {
            spotifyService.getTrack(Consts.TRACK_NAME);
        });
        String message = exception.getMessage();

        assertNotNull(exception);
        assertEquals(message, exception.getMessage());
    }
}