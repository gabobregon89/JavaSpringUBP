package com.spring.ubp.JavaSpringUBP.dto.spotify;

import lombok.Data;

@Data
public class TrackResponse {

    private String spotifyId;
    private String name;
    private int durationMs;
    private String artist;
}
