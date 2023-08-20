package com.spring.ubp.JavaSpringUBP.service;

import com.spring.ubp.JavaSpringUBP.dto.TrackDTO;
import com.spring.ubp.JavaSpringUBP.model.Track;
import com.spring.ubp.JavaSpringUBP.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public TrackDTO createTrack(TrackDTO trackDTO) {
        Track trackSaved = trackRepository.save(trackDTOToEntity(trackDTO));
        return trackEntityToDTO(trackSaved);
    }

    @Override
    public TrackDTO getTrack(String name) {
        Track track = trackRepository.findByName(name);
        return trackEntityToDTO(track);
    }

    @Override
    public TrackDTO updateTrackById(Integer id, TrackDTO trackDTO) {
        return null;
    }

    @Override
    public void deleteTrackById(Integer id) {

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
