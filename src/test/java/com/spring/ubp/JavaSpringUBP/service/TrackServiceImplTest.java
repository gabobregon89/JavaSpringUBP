package com.spring.ubp.JavaSpringUBP.service;

import com.spring.ubp.JavaSpringUBP.dto.TrackDTO;
import com.spring.ubp.JavaSpringUBP.model.Track;
import com.spring.ubp.JavaSpringUBP.repository.TrackRepository;
import com.spring.ubp.JavaSpringUBP.utils.Consts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TrackServiceImplTest {

    TrackServiceImpl trackService;

    TrackRepository trackRepository = mock(TrackRepository.class);

    @BeforeEach
    void setUp() {
        trackService = new TrackServiceImpl(trackRepository);
    }

    @Test
    void createTrack() {
        TrackDTO trackDTO = Consts.createValidTrackDTO();
        Track track = Consts.createValidTrack();

        when(trackRepository.save(track)).thenReturn(track);

        TrackDTO response = trackService.createTrack(trackDTO);

        assertNotNull(response);
        assertEquals(TrackDTO.class, response.getClass());
        assertEquals(Consts.SPOTIFY_ID, response.getSpotifyId());
        assertEquals(Consts.TRACK_NAME, response.getName());
        assertEquals(Consts.DURATION_MS, response.getDurationMs());
        assertEquals(Consts.PLAYLIST, response.getPlaylistName());
        assertEquals(Consts.ARTIST, response.getArtist());
        verify(trackRepository).save(any());
    }

    @Test
    void getTrack() {
    }

    @Test
    void getAllTracks() {
    }

    @Test
    void updatePlaylistOfTrackById() {
    }

    @Test
    void deleteTrackById() {
    }

    @Test
    void getTracksByPlaylist() {
    }
}