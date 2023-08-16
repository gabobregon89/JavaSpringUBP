package com.spring.ubp.JavaSpringUBP.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private Long id;

    private String name;
    private String genre;

    @Column(name = "release_year")
    private String releaseYear;

    @Column(name = "total_tracks")
    private int totalTracks;

    @OneToOne(mappedBy = "album", cascade = CascadeType.ALL)
    private Artist artist;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "album_track")
    private List<Track> tracks = new ArrayList<>();

}
