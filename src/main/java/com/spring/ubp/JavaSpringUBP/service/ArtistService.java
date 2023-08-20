package com.spring.ubp.JavaSpringUBP.service;

import com.spring.ubp.JavaSpringUBP.dto.spotify.CompleteSpotify;

public interface ArtistService {

    CompleteSpotify getArtistByName(String name);
}
