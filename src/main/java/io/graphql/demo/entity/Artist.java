package io.graphql.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Artist")
@Table(name = "Artist")
@Setter
@ToString
@EqualsAndHashCode(of = {"artistId", "name", "country"})
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artistId")
    private int artistId;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artist")
    private List<Song> songs = new ArrayList<Song>();

    @GraphQLQuery(name = "artistId", description = "id")
    public int getArtistId() {
        return artistId;
    }

    @GraphQLQuery(name = "name", description = "The name")
    public String getName() {
        return name;
    }

    @GraphQLQuery(name = "country", description = "The country where artist lives")
    public String getCountry() {
        return country;
    }

    @GraphQLQuery(name = "songs", description = "The songs")
    public List<Song> getSongs() {
        return songs;
    }
}
