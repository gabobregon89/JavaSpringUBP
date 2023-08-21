package com.spring.ubp.JavaSpringUBP.service;

import com.spring.ubp.JavaSpringUBP.dto.TrackDTO;
import com.spring.ubp.JavaSpringUBP.exception.PlaylistNotExistException;
import com.spring.ubp.JavaSpringUBP.exception.TrackNotFoundException;
import com.spring.ubp.JavaSpringUBP.model.Track;
import com.spring.ubp.JavaSpringUBP.repository.TrackRepository;
import com.spring.ubp.JavaSpringUBP.utils.Consts;
import org.apache.tomcat.util.bcel.Const;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Track track = Consts.createValidTrack();

        when(trackRepository.save(track)).thenReturn(track);

        TrackDTO response = trackService.createTrack(Consts.createValidTrackDTO());

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
    @DisplayName("getTrack of user")
    void getTrack() {
        Optional<Track> optional = Optional.of(Consts.createValidTrack());

        when(trackRepository.findByName(Consts.TRACK_NAME)).thenReturn(optional);

        TrackDTO response = trackService.getTrack(Consts.TRACK_NAME);

        assertNotNull(response);
        assertEquals(Consts.SPOTIFY_ID, response.getSpotifyId());
        assertEquals(Consts.TRACK_NAME, response.getName());
        assertEquals(Consts.DURATION_MS, response.getDurationMs());
        assertEquals(Consts.PLAYLIST, response.getPlaylistName());
        assertEquals(Consts.ARTIST, response.getArtist());
    }

    @Test
    @DisplayName("getTrack, but track does not exist")
    void getTrackNotFoundException() {
        Optional<Track> optional = Optional.empty();

        when(trackRepository.findByName(Consts.TRACK_NAME)).thenReturn(optional);

        Exception exception = assertThrows(TrackNotFoundException.class, ()-> {
            trackService.getTrack(Consts.TRACK_NAME);
        });

        assertNotNull(exception);
        assertEquals("track no encontrado con: name, 'Salvame'", exception.getMessage());
    }

    @Test
    @DisplayName("get all tracks created by user")
    void getAllTracks() {
        List<Track> tracks = new ArrayList<>();
        tracks.add(Consts.createValidTrack());

        when(trackRepository.findAll()).thenReturn(tracks);

        List<TrackDTO> response = trackService.getAllTracks();

        TrackDTO trackDTO = response.get(0);
        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Consts.SPOTIFY_ID, trackDTO.getSpotifyId());
        assertEquals(Consts.TRACK_NAME, trackDTO.getName());
        assertEquals(Consts.DURATION_MS, trackDTO.getDurationMs());
        assertEquals(Consts.PLAYLIST, trackDTO.getPlaylistName());
        assertEquals(Consts.ARTIST, trackDTO.getArtist());
    }

    @Test
    @DisplayName("updated the playlist name")
    void updatePlaylistOfTrackById() {
        Optional<Track> optional = Optional.of(Consts.createValidTrack());

        when(trackRepository.findById(Consts.TRACK_ID.longValue())).thenReturn(optional);
        when(trackRepository.save(Consts.createValidTrack())).thenReturn(Consts.createValidTrack());

        TrackDTO response = trackService.updatePlaylistOfTrackById(Consts.TRACK_ID, Consts.PLAYLIST);

        assertNotNull(response);
        assertEquals(Consts.SPOTIFY_ID, response.getSpotifyId());
        assertEquals(Consts.TRACK_NAME, response.getName());
        assertEquals(Consts.DURATION_MS, response.getDurationMs());
        assertEquals(Consts.PLAYLIST, response.getPlaylistName());
        assertEquals(Consts.ARTIST, response.getArtist());
    }

    @Test
    @DisplayName("deleted a track")
    void deleteTrackById() {
        Optional<Track> optional = Optional.of(Consts.createValidTrack());

        when(trackRepository.findById(Consts.TRACK_ID.longValue())).thenReturn(optional);
        doNothing().when(trackRepository).delete(Consts.createValidTrack());

        trackService.deleteTrackById(Consts.TRACK_ID);

        verify(trackRepository).findById(anyLong());
        verify(trackRepository).delete(any(Track.class));
    }

    @Test
    @DisplayName("get all tracks by a playlist name")
    void getTracksByPlaylist() {
        List<Track> tracks = new ArrayList<>();
        tracks.add(Consts.createValidTrack());

        when(trackRepository.findAllByPlaylistName(Consts.PLAYLIST)).thenReturn(tracks);

        List<TrackDTO> response = trackService.getTracksByPlaylist(Consts.PLAYLIST);

        TrackDTO trackDTO = response.get(0);
        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Consts.SPOTIFY_ID, trackDTO.getSpotifyId());
        assertEquals(Consts.TRACK_NAME, trackDTO.getName());
        assertEquals(Consts.DURATION_MS, trackDTO.getDurationMs());
        assertEquals(Consts.PLAYLIST, trackDTO.getPlaylistName());
        assertEquals(Consts.ARTIST, trackDTO.getArtist());
    }

    @Test
    @DisplayName("exception because not exist playlist with that name")
    void getTracksByPlaylistPlaylistNotExistException() {
        List<Track> tracks = new ArrayList<>();

        when(trackRepository.findAllByPlaylistName(Consts.PLAYLIST)).thenReturn(tracks);

        Exception exception = assertThrows(PlaylistNotExistException.class, ()-> {
            trackService.getTracksByPlaylist(Consts.PLAYLIST);
        });

        assertNotNull(exception);
        assertEquals("Not exists playlist with that name", exception.getMessage());

    }
}