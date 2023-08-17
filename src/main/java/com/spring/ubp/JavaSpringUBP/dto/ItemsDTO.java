package com.spring.ubp.JavaSpringUBP.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemsDTO {

    private List<String> items = new ArrayList<>();
}
