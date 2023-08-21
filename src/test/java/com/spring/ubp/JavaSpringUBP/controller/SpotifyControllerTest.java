package com.spring.ubp.JavaSpringUBP.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.ubp.JavaSpringUBP.dto.spotify.ItemsTrack;
import com.spring.ubp.JavaSpringUBP.dto.spotify.TrackResponse;
import com.spring.ubp.JavaSpringUBP.dto.spotify.TracksSpotify;
import com.spring.ubp.JavaSpringUBP.service.SpotifyServiceImpl;
import com.spring.ubp.JavaSpringUBP.utils.Consts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SpotifyControllerTest {

    SpotifyController spotifyController;

    SpotifyServiceImpl spotifyService = mock(SpotifyServiceImpl.class);

    @BeforeEach
    void setUp() {
        spotifyController = new SpotifyController();
        ReflectionTestUtils.setField(spotifyController, "spotifyService", spotifyService);
    }

    @Test
    @DisplayName("get all tracks by an artist in spotify")
    void getTracksByArtist() throws JsonProcessingException {
        TracksSpotify tracksSpotify = Consts.createValidTracksSpotifyResponse();

        when(spotifyService.getTracksByArtist(Consts.ARTIST)).thenReturn(tracksSpotify);

        TracksSpotify response = spotifyController.getTracksByArtist(Consts.ARTIST);

        ItemsTrack trackResponse = response.getItems().get(0);
        assertNotNull(response);
        assertEquals(1, response.getItems().size());
        assertEquals("jsdAD12Gzas5zz", trackResponse.getId());
        assertEquals("Salvame", trackResponse.getName());
        assertEquals(360000, trackResponse.getDuration_ms());
    }

    @Test
    @DisplayName("get a track by name in spotify")
    void getTrack() throws JsonProcessingException {

        when(spotifyService.getTrack(Consts.TRACK_NAME)).thenReturn(Consts.createValidTrackResponse());

        TrackResponse response = spotifyController.getTrack(Consts.TRACK_NAME);

        assertNotNull(response);
        assertEquals(Consts.SPOTIFY_ID, response.getSpotifyId());
        assertEquals(Consts.TRACK_NAME, response.getName());
        assertEquals(Consts.DURATION_MS, response.getDurationMs());
        assertEquals(Consts.ARTIST, response.getArtist());
    }
}