package com.spring.ubp.JavaSpringUBP.dto.spotify;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemsTrack {

    private String id;
    private String name;
    private int duration_ms;
}
