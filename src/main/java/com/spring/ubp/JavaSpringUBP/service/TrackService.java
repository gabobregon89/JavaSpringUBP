package com.spring.ubp.JavaSpringUBP.service;

import com.spring.ubp.JavaSpringUBP.dto.TrackDTO;

public interface TrackService {

    TrackDTO createTrack(TrackDTO trackDTO);

    TrackDTO getTrack(String name);
}
