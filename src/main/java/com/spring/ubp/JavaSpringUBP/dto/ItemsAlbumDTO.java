package com.spring.ubp.JavaSpringUBP.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.ubp.JavaSpringUBP.model.Album2;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemsAlbumDTO {

    private List<Album2> items;
}
