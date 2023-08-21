package com.spring.ubp.JavaSpringUBP.utils;

import com.spring.ubp.JavaSpringUBP.dto.TrackDTO;
import com.spring.ubp.JavaSpringUBP.dto.spotify.ItemsTrack;
import com.spring.ubp.JavaSpringUBP.dto.spotify.TracksSpotify;
import com.spring.ubp.JavaSpringUBP.model.Track;

import java.util.ArrayList;
import java.util.List;

public class Consts {

    public static final String ARTIST = "Los Cafres";
    public static final String SPOTIFY_ID = "jsdAD12Gzas5zz";
    public static final String TRACK_NAME = "Salvame";
    public static final int DURATION_MS = 360000;
    public static final String PLAYLIST = "La playlist";
    public static final String SPOTIFY_TOKEN = "ajkshadlahslfalsnl1n2nltnl345l235l2kngkltnb24k3l5234nlkn23l4n2ln34l2";
    public static final String URL_BASE = "https://endpointfalse.com/v100/find?somehting={NAME}";
    public static final String ENDPOINT_FALSE = "https://endpointfalse.com/v100/find?somehting=Los%20Cafres";
    public static final String JSON_ITEMS = "{\"tracks\": {\"items\": [{\"id\": \"laisjdolanmla23nb2kk3\", \"name\": \"Salvame\", \"duration_ms\": \"360000\"}]}}";

    public static ItemsTrack createValidItemsTrackResponse() {
        ItemsTrack itemsTrack = new ItemsTrack();
        itemsTrack.setId(SPOTIFY_ID);
        itemsTrack.setName(TRACK_NAME);
        itemsTrack.setDuration_ms(DURATION_MS);
        return itemsTrack;
    }

    public static TracksSpotify createValidTracksSpotifyResponse() {
        TracksSpotify tracksSpotify = new TracksSpotify();
        List<ItemsTrack> items = new ArrayList<>();
        ItemsTrack itemsTrack = createValidItemsTrackResponse();
        items.add(itemsTrack);
        tracksSpotify.setItems(items);
        return tracksSpotify;
    }

    public static TrackDTO createValidTrackDTO() {
        TrackDTO trackDTO = new TrackDTO();
//        trackDTO.setId(1L);
        trackDTO.setSpotifyId(SPOTIFY_ID);
        trackDTO.setName(TRACK_NAME);
        trackDTO.setDurationMs(DURATION_MS);
        trackDTO.setPlaylistName(PLAYLIST);
        trackDTO.setArtist(ARTIST);
        return trackDTO;
    }

    public static Track createValidTrack() {
        Track track = new Track();
//        track.setId(1L);
        track.setSpotifyId(SPOTIFY_ID);
        track.setName(TRACK_NAME);
        track.setDurationMs(DURATION_MS);
        track.setPlaylistName(PLAYLIST);
        track.setArtist(ARTIST);
        return track;
    }
}
