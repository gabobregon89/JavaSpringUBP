package com.spring.ubp.JavaSpringUBP.service;

import com.spring.ubp.JavaSpringUBP.dto.TrackDTO;
import com.spring.ubp.JavaSpringUBP.exception.TrackNotFoundException;
import com.spring.ubp.JavaSpringUBP.model.Track;
import com.spring.ubp.JavaSpringUBP.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public TrackDTO createTrack(TrackDTO trackDTO) {
        Track savedTrack = trackRepository.save(trackDTOToEntity(trackDTO));
        return trackEntityToDTO(savedTrack);
    }

    @Override
    public TrackDTO getTrack(String name) {
        Track track = trackRepository.findByName(name)
                .orElseThrow(()-> new TrackNotFoundException("track", "name", name));
        return trackEntityToDTO(track);
    }

    @Override
    public List<TrackDTO> getAllTracks() {
        List<Track> tracks = trackRepository.findAll();
        List<TrackDTO> dtos = new ArrayList<>();
        for (Track track : tracks) {
            dtos.add(trackEntityToDTO(track));
        }
        return dtos;
    }

    @Override
    public TrackDTO updatePlaylistOfTrackById(Integer id, String playlistName) {
        Track track = trackRepository.findById(id.longValue()).orElseThrow(
                ()-> new TrackNotFoundException("track", "id", id.toString()));

        track.setPlaylistName(playlistName);
        Track updatedTrack = trackRepository.save(track);
        return trackEntityToDTO(updatedTrack);
    }

    @Override
    public void deleteTrackById(Integer id) {
        Track track = trackRepository.findById(id.longValue()).orElseThrow(
                ()-> new TrackNotFoundException("track", "id", id.toString()));
        trackRepository.delete(track);
    }

    @Override
    public List<TrackDTO> getTracksByPlaylist(String playlistName) {
        List<Track> tracks = trackRepository.findAllByPlaylistName(playlistName);
        List<TrackDTO> dtos = new ArrayList<>();
        for (Track track : tracks) {
            dtos.add(trackEntityToDTO(track));
        }
        return dtos;
    }

    //Convierto de DTO a Entity
    private Track trackDTOToEntity(TrackDTO dto) {
        Track track = new Track();

        track.setSpotifyId(dto.getSpotifyId());
        track.setName(dto.getName());
        track.setDurationMs(dto.getDurationMs());
        track.setPlaylistName(dto.getPlaylistName());
        track.setArtist(dto.getArtist());

        return track;
    }

    //Convierto de Entity a DTO
    private TrackDTO trackEntityToDTO(Track track) {
        TrackDTO dto = new TrackDTO();

        dto.setId(track.getId());
        dto.setSpotifyId(track.getSpotifyId());
        dto.setName(track.getName());
        dto.setDurationMs(track.getDurationMs());
        dto.setPlaylistName(track.getPlaylistName());
        dto.setArtist(track.getArtist());

        return dto;
    }
}
