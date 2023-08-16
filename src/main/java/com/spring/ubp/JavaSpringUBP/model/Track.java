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

    private String name;

    @Column(name = "duration_seg")
    private int durationSeg;

    @Column(name = "track_number")
    private int trackNumber;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "album_id")
    private Album album;
}
