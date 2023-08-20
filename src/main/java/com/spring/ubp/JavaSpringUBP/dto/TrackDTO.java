package com.spring.ubp.JavaSpringUBP.dto;

import lombok.Data;

@Data
public class TrackDTO {

    private Long id;
    private String spotifyId;
    private String name;
    private int durationMs;
    private String playlistName;
    private String artist;

}
