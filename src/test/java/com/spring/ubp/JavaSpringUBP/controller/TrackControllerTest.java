package com.spring.ubp.JavaSpringUBP.controller;

import com.spring.ubp.JavaSpringUBP.dto.TrackDTO;
import com.spring.ubp.JavaSpringUBP.service.TrackServiceImpl;
import com.spring.ubp.JavaSpringUBP.utils.Consts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TrackControllerTest {

    TrackController trackController;

    TrackServiceImpl trackService = mock(TrackServiceImpl.class);

    @BeforeEach
    void setUp() {
        trackController = new TrackController();
        ReflectionTestUtils.setField(trackController, "trackService", trackService);
    }

    @Test
    void postTrack() {

        when(trackService.createTrack(Consts.createValidTrackDTO())).thenReturn(Consts.createValidTrackDTO());

        ResponseEntity<TrackDTO> response = trackController.postTrack(Consts.createValidTrackDTO());

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(TrackDTO.class, response.getBody().getClass());
    }

    @Test
    void getTrack() {
        when(trackService.getTrack(Consts.TRACK_NAME)).thenReturn(Consts.createValidTrackDTO());

        ResponseEntity<TrackDTO> response = trackController.getTrack(Consts.TRACK_NAME);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(TrackDTO.class, response.getBody().getClass());
        assertEquals(Consts.TRACK_NAME, response.getBody().getName());
    }

    @Test
    @DisplayName("get all tracks that user saved")
    void getAllTracks() {
        List<TrackDTO> list = new ArrayList<>();
        list.add(Consts.createValidTrackDTO());

        when(trackService.getAllTracks()).thenReturn(list);

        ResponseEntity<List<TrackDTO>> response = trackController.getAllTracks();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void updateTrack() {
        when(trackService.updatePlaylistOfTrackById(Consts.TRACK_ID, Consts.PLAYLIST)).thenReturn(Consts.createValidTrackDTO());

        ResponseEntity<TrackDTO> response = trackController.updateTrack(Consts.TRACK_ID, Consts.PLAYLIST);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(TrackDTO.class, response.getBody().getClass());
        assertEquals(Consts.PLAYLIST, response.getBody().getPlaylistName());
    }

    @Test
    void deleteTrack() {
        doNothing().when(trackService).deleteTrackById(Consts.TRACK_ID);

        ResponseEntity<String> response = trackController.deleteTrack(Consts.TRACK_ID);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Track deleted successfully", response.getBody());
    }

    @Test
    @DisplayName("get all tracks that share playlist")
    void getPlaylist() {
        List<TrackDTO> list = new ArrayList<>();
        list.add(Consts.createValidTrackDTO());

        when(trackService.getTracksByPlaylist(Consts.PLAYLIST)).thenReturn(list);

        ResponseEntity<List<TrackDTO>> response = trackController.getPlaylist(Consts.PLAYLIST);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }
}