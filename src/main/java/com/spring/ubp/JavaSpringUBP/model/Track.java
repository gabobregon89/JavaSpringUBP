package com.spring.ubp.JavaSpringUBP.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tracks")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_id")
    private Long id;

    @Column(name = "spotify_id")
    private String spotifyId;

    private String name;

    @Column(name = "duration_ms")
    private int durationMs;

    @Column(name = "playlist_name")
    private String playlistName;

    private String artist;
}
