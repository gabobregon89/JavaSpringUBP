package com.spring.ubp.JavaSpringUBP.repository;

import com.spring.ubp.JavaSpringUBP.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long> {

    Track findByName(String name);
}
