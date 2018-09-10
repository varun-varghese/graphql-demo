package io.graphql.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.graphql.demo.entity.Artist;
import io.graphql.demo.repository.ArtistRepository;

@Service
public class ArtistService {
    
    @Autowired
    private ArtistRepository artistRepository;
    
    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }
    
    public Iterable<Artist> saveAll(List<Artist> artists) {
        return artistRepository.saveAll(artists);
    }
    
    public Optional<Artist> getById(int id) {
        return artistRepository.findById(id);
    }
    
    public Artist getByName(String name) {
        return artistRepository.findByName(name);
    }

    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

}
