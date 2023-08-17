package com.spring.ubp.JavaSpringUBP.service;

import com.spring.ubp.JavaSpringUBP.dto.ArtistDTO;
import com.spring.ubp.JavaSpringUBP.dto.TodoDTO;

public interface ArtistService {

    TodoDTO getArtistByName(String name);
}
