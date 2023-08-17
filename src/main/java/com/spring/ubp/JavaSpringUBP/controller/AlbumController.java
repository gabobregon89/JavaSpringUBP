package com.spring.ubp.JavaSpringUBP.controller;

import com.spring.ubp.JavaSpringUBP.model.Album2;
import com.spring.ubp.JavaSpringUBP.service.AlbumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiV1/albums")
public class AlbumController {

    @Autowired
    private AlbumServiceImpl albumService;

    @GetMapping("/{name}")
    public Album2 getAlbums(@PathVariable(name = "name") String name) {
        return albumService.getAllAlbums(name);
    }
}
