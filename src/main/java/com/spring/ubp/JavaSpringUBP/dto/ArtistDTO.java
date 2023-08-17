package com.spring.ubp.JavaSpringUBP.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistDTO {

    private String id;
    private String name;
}
