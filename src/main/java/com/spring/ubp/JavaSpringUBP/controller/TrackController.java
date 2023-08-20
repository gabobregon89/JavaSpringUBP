package com.spring.ubp.JavaSpringUBP.controller;

import com.spring.ubp.JavaSpringUBP.dto.TrackDTO;
import com.spring.ubp.JavaSpringUBP.service.TrackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/{id}")
    public TrackDTO updateTrack(@PathVariable(name = "id") Integer id, @RequestBody TrackDTO trackDTO) {
        return trackService.updateTrackById(id, trackDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteTrack(@PathVariable(name = "id") Integer id) {
        String message = "Track deleted successfully";
        trackService.deleteTrackById(id);
        return message;
    }
}
