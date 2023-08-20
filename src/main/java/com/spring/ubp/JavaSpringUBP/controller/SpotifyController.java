package com.spring.ubp.JavaSpringUBP.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.ubp.JavaSpringUBP.dto.spotify.TrackResponse;
import com.spring.ubp.JavaSpringUBP.dto.spotify.TracksSpotify;
import com.spring.ubp.JavaSpringUBP.service.SpotifyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiV1/spotify")
public class SpotifyController {

    @Autowired
    private SpotifyServiceImpl spotifyService;

    @GetMapping
    public TracksSpotify getTracksByArtist(@RequestParam(name = "name") String name) throws JsonProcessingException {
        return spotifyService.getTracksByArtist(name);
    }

    @GetMapping("/{track}")
    public TrackResponse getTrack(@PathVariable(name = "track") String track) throws JsonProcessingException {
        return spotifyService.getTrack(track);
    }
}
