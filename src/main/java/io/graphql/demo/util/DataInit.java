package io.graphql.demo.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.graphql.demo.entity.Artist;
import io.graphql.demo.entity.Song;
import io.graphql.demo.service.ArtistService;
import io.graphql.demo.service.SongService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DataInit {
    
    @Autowired
    private ArtistService artistService;
    
    @Autowired
    private SongService songService;
    
    @PostConstruct
    public void init() {
        populateArtists();
        populateSongs();
        //associateSongsToArtist();
    }
    
    public void populateArtists() {
        Artist artist1 = new Artist();
        artist1.setName("Tom Petty");
        artist1.setCountry("US");
        artistService.save(artist1);

        Artist artist2 = new Artist();
        artist2.setName("Elton John");
        artist2.setCountry("UK");
        artistService.save(artist2);
    }
    
    public void populateSongs() {
        Artist tom = artistService.getByName("Tom Petty");
        Artist elton = artistService.getByName("Elton John");
        
        Song song1 = new Song();
        song1.setTitle("Free Falling'");
        song1.setGenre("Classic Rock");
        song1.setDuration(5);
        song1.setArtist(tom);
        songService.save(song1);

        Song song2 = new Song();
        song2.setTitle("I Won't Back Down");
        song2.setGenre("Classic Rock");
        song2.setDuration(4);
        song2.setArtist(tom);
        songService.save(song2);

        Song song3 = new Song();
        song3.setTitle("Learning to Fly");
        song3.setGenre("Classic Rock");
        song3.setDuration(3);
        song3.setArtist(tom);
        songService.save(song3);

        Song song4 = new Song();
        song4.setTitle("Rocket Man");
        song4.setGenre("Soft Rock");
        song4.setDuration(5);
        song4.setArtist(elton);
        songService.save(song4);

        Song song5 = new Song();
        song5.setTitle("Tiny Dancer");
        song5.setGenre("Pop");
        song5.setDuration(4);
        song5.setArtist(elton);
        songService.save(song5);

        Song song6 = new Song();
        song6.setTitle("Don't Go Breaking My Heart");
        song6.setGenre("Pop");
        song6.setDuration(5);
        song6.setArtist(elton);
        songService.save(song6);
    }
    
    public void associateSongsToArtist() {
        Artist tom = artistService.getByName("Tom Petty");
        tom.setSongs(songService.findAllByArtist("Tom Petty"));
        artistService.save(tom);
        
        Artist elton = artistService.getByName("Elton John");
        elton.setSongs(songService.findAllByArtist("Elton John"));
        artistService.save(elton);
    }

}
