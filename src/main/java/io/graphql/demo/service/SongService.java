package io.graphql.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.graphql.demo.entity.Song;
import io.graphql.demo.repository.SongRepository;

@Service
public class SongService {
    
    @Autowired
    private SongRepository songRepository;
    
    public Optional<Song> getById(int id) {
        return songRepository.findById(id);
    }
    
    public Song findByTitle(String title) {
        return songRepository.findByTitle(title);
    }
    
    public List<Song> findAllByArtist(String artist) {
        return songRepository.findAllByArtistName(artist);
    }
    
    public List<Song> findAllByGenre(String genre) {
        return songRepository.findAllByGenre(genre);
    }
    
    public List<Song> findAllByDurationGreaterThanEqual(int duration) {
        return songRepository.findAllByDurationGreaterThanEqual(duration);
    }

    public Song save(Song song) {
        return songRepository.save(song);
    }
    
    public Iterable<Song> saveAll(List<Song> songs) {
        return songRepository.saveAll(songs);
    }

}
