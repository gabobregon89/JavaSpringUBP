package com.spring.ubp.JavaSpringUBP.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Album2 {

    private String album;
    private String name;
}
