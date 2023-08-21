package com.spring.ubp.JavaSpringUBP.controller;

import com.spring.ubp.JavaSpringUBP.dto.TrackDTO;
import com.spring.ubp.JavaSpringUBP.service.TrackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiV1/tracks")
public class TrackController {

    @Autowired
    private TrackServiceImpl trackService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseEntity<TrackDTO> postTrack(@RequestBody TrackDTO trackDTO) {
        TrackDTO response = trackService.createTrack(trackDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TrackDTO> getTrack(@PathVariable(name = "name") String name) {
        TrackDTO response = trackService.getTrack(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TrackDTO>> getAllTracks() {
        List<TrackDTO> response = trackService.getAllTracks();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<TrackDTO> updateTrack(@PathVariable(name = "id") Integer id, @RequestBody String playlistName) {
        TrackDTO response = trackService.updatePlaylistOfTrackById(id, playlistName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrack(@PathVariable(name = "id") Integer id) {
        String message = "Track deleted successfully";
        trackService.deleteTrackById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/playlist")
    public ResponseEntity<List<TrackDTO>> getPlaylist(@RequestParam(name = "name") String playlistName) {
        List<TrackDTO> response = trackService.getTracksByPlaylist(playlistName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
