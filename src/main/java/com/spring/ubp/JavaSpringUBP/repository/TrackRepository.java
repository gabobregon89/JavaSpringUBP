package com.spring.ubp.JavaSpringUBP.repository;

import com.spring.ubp.JavaSpringUBP.exception.TrackNotFoundException;
import com.spring.ubp.JavaSpringUBP.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrackRepository extends JpaRepository<Track, Long> {

    Optional<Track> findByName(String name);
}
