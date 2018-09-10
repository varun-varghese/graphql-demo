package io.graphql.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.graphql.demo.entity.Song;


@Repository
public interface SongRepository extends CrudRepository<Song, Integer> {

    public Song findByTitle(String title);
    
    public List<Song> findAllByArtistName(String artistName);
    
    public List<Song> findAllByGenre(String genre);
    
    public List<Song> findAllByDurationGreaterThanEqual(int duration);

}
