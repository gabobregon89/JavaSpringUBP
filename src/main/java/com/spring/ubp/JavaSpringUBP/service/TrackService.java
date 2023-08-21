package com.spring.ubp.JavaSpringUBP.service;

import com.spring.ubp.JavaSpringUBP.dto.TrackDTO;

import java.util.List;

public interface TrackService {

    TrackDTO createTrack(TrackDTO trackDTO);

    TrackDTO getTrack(String name);

    List<TrackDTO> getAllTracks();

    TrackDTO updatePlaylistOfTrackById(Integer id, String playlistName);

    void deleteTrackById(Integer id);

    List<TrackDTO> getTracksByPlaylist(String playlistName);
}
