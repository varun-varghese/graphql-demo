package io.graphql.demo.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.graphql.demo.entity.Artist;
import io.graphql.demo.service.ArtistService;
import io.graphql.demo.util.BasicBuilder;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Component
public class ArtistQuery {
    
    @Autowired
    private ArtistService artistService;
    
    @Autowired
    private BasicBuilder basicBuilder;
    
    @GraphQLMutation(name = "createArtist")
    public Artist createArtist(@GraphQLArgument(name = "name") String name, 
        @GraphQLArgument(name = "country") String country) {
        return artistService.save(basicBuilder.createArtist(name, country));
    }
    
    @GraphQLMutation(name = "createArtist")
    public Artist createArtist(@GraphQLArgument(name = "artist") Artist artist) {
        return artistService.save(artist);
    }
    
    @GraphQLMutation(name = "createArtists")
    public Iterable<Artist> createArtists(@GraphQLArgument(name = "artists") List<Artist> artists) {
        return artistService.saveAll(artists);
    }
    
    @GraphQLQuery(name = "artistById")
    public Artist getArtistById(@GraphQLArgument(name = "id") int id) {
        return artistService.getById(id).orElse(null);
    }
    
    @GraphQLQuery(name = "artistByName")
    public Artist getArtistByName(@GraphQLArgument(name = "name") String name) {
        return artistService.getByName(name);
    }
    
    @GraphQLQuery(name = "allArtists")
    public List<Artist> getAllArtists() {
        return artistService.findAll();
    }

}
