package com.spring.ubp.JavaSpringUBP.controller;

import com.spring.ubp.JavaSpringUBP.dto.ArtistDTO;
import com.spring.ubp.JavaSpringUBP.dto.TodoDTO;
import com.spring.ubp.JavaSpringUBP.service.ArtistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiV1/artists")
public class ArtistController {

    @Autowired
    private ArtistServiceImpl artistService;

    @GetMapping("/{name}")
    public ArtistDTO getArtist(@PathVariable(name = "name") String name) {
        TodoDTO todoDTO = artistService.getArtistByName(name);
        ArtistDTO artistDTO = todoDTO.getArtists().getItems().get(0);
        return artistDTO;
    }
}
