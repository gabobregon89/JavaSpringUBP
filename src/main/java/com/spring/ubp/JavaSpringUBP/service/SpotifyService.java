package com.spring.ubp.JavaSpringUBP.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.ubp.JavaSpringUBP.dto.spotify.TrackResponse;
import com.spring.ubp.JavaSpringUBP.dto.spotify.TracksSpotify;

public interface SpotifyService {

    TracksSpotify getTracksByArtist(String name) throws JsonProcessingException;

    TrackResponse getTrack(String track) throws JsonProcessingException;
}
