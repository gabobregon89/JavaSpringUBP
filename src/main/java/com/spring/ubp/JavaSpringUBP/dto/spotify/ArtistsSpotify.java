package com.spring.ubp.JavaSpringUBP.dto.spotify;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistsSpotify {

    private List<ItemsArtist> items;
}
