package com.spring.ubp.JavaSpringUBP.controller;

import com.spring.ubp.JavaSpringUBP.dto.ArtistDTO;
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
        ArtistDTO artistDTO = artistService.getArtistByName(name);
        return artistDTO;
    }
}
