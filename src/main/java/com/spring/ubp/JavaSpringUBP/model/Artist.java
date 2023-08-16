package com.spring.ubp.JavaSpringUBP.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id")
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "album_id", referencedColumnName = "album_id")
    private Album album;
}
