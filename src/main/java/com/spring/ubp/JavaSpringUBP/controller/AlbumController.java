package com.spring.ubp.JavaSpringUBP.controller;

import com.spring.ubp.JavaSpringUBP.model.Album;
import com.spring.ubp.JavaSpringUBP.model.Album2;
import com.spring.ubp.JavaSpringUBP.service.AlbumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiV1/albums")
public class AlbumController {

    @Autowired
    private AlbumServiceImpl albumService;

    @GetMapping
    public Album2 getAlbums() {
        return albumService.getAllAlbums();
    }
}
