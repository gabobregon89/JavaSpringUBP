package com.spring.ubp.JavaSpringUBP.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TodoDTO {

    private ItemsDTO artists;

    private ItemsAlbumDTO albums;
}
