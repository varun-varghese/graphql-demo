package io.graphql.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.graphql.demo.entity.Artist;


@Repository
public interface ArtistRepository extends CrudRepository<Artist, Integer> {

    public Artist findByName(String name);
    
    public List<Artist> findAll();

}
