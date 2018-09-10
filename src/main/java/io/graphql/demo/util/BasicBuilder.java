package io.graphql.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.graphql.demo.entity.Artist;
import io.graphql.demo.entity.Song;
import io.graphql.demo.service.ArtistService;

@Component
public class BasicBuilder {
    
    @Autowired
    private ArtistService artistService;

    public Artist createArtist(String name, String country) {
        Artist artist = new Artist();
        artist.setName(name);
        artist.setCountry(country);
        return artist;
    }
    
    public Song createSong(String artist, int duration, String genre, String title) {
        Song song = new Song();
        song.setDuration(duration);
        song.setGenre(genre);
        song.setTitle(title);
        
        Artist theArtist = artistService.getByName(artist);
        if (null != theArtist) {
            song.setArtist(theArtist);
        }
        return song;
    }
}
