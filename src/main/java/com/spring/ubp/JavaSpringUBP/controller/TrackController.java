package com.spring.ubp.JavaSpringUBP.controller;

import com.spring.ubp.JavaSpringUBP.dto.TrackDTO;
import com.spring.ubp.JavaSpringUBP.service.TrackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiV1/tracks")
public class TrackController {

    @Autowired
    private TrackServiceImpl trackService;

    @PostMapping
    public TrackDTO postTrack(@RequestBody TrackDTO trackDTO) {
        return trackService.createTrack(trackDTO);
    }

    @GetMapping("/{name}")
    public TrackDTO getTrack(@PathVariable(name = "name") String name) {
        return trackService.getTrack(name);
    }
}
