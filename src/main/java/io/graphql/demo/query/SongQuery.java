package io.graphql.demo.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.graphql.demo.entity.Song;
import io.graphql.demo.service.SongService;
import io.graphql.demo.util.BasicBuilder;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Component
public class SongQuery {
    
    @Autowired
    private SongService songService;
    
    @Autowired
    private BasicBuilder basicBuilder;
    
    @GraphQLMutation(name = "createSong")
    public Song createSong(@GraphQLArgument(name = "artist") String artist,
        @GraphQLArgument(name = "duration")int duration, 
        @GraphQLArgument(name = "genre") String genre, 
        @GraphQLArgument(name = "title") String title) {
        return songService.save(basicBuilder.createSong(artist, duration, genre, title));
    }
    
    @GraphQLMutation(name = "createSong")
    public Song createSong(@GraphQLArgument(name = "song") Song song) {
        return songService.save(song);
    }
    
    @GraphQLMutation(name = "createSongs")
    public Iterable<Song> createSongs(@GraphQLArgument(name = "songs") List<Song> songs) {
        return songService.saveAll(songs);
    }
    
    @GraphQLQuery(name = "songById")
    public Song getSongById(@GraphQLArgument(name = "id") int id) {
        return songService.getById(id).orElse(null);
    }
    
    @GraphQLQuery(name = "songByTitle")
    public Song getSongByTitle(@GraphQLArgument(name = "title") String title) {
        return songService.findByTitle(title);
    }
    
    @GraphQLQuery(name = "songsByArtist")
    public List<Song> getSongsByArtist(@GraphQLArgument(name = "artist") String artist) {
        return songService.findAllByArtist(artist);
    }
    
    @GraphQLQuery(name = "songsByGenre")
    public List<Song> getSongsByGenre(@GraphQLArgument(name = "genre") String genre) {
        return songService.findAllByGenre(genre);
    }
    
    @GraphQLQuery(name = "songsGreaterThanDuration")
    public List<Song> getSongsGreaterThanDuration(@GraphQLArgument(name = "duration") int duration) {
        return songService.findAllByDurationGreaterThanEqual(duration);
    }

}
