package com.spring.ubp.JavaSpringUBP.dto.spotify;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompleteSpotify {

    private TracksSpotify tracks;

    private ArtistsSpotify artists;

}
