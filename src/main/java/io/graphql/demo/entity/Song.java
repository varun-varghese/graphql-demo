package io.graphql.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Song")
@Table(name = "Song")
@Setter
@ToString
@EqualsAndHashCode(of = {"songId", "title", "duration", "genre"})
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "songId")
    private int songId;

    @Column(name = "title")
    private String title;

    @Column(name = "duration")
    private int duration;

    @Column(name = "genre")
    private String genre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artistId")
    @GraphQLQuery(name = "artist", description = "The artist")
    private Artist artist;

    @GraphQLQuery(name = "songId", description = "id")
    public int getSongId() {
        return songId;
    }

    @GraphQLQuery(name = "title", description = "Title of the song")
    public String getTitle() {
        return title;
    }

    @GraphQLQuery(name = "duration", description = "Duration of the song")
    public int getDuration() {
        return duration;
    }

    @GraphQLQuery(name = "genre", description = "genre of the song")
    public String getGenre() {
        return genre;
    }

    public Artist getArtist() {
        return artist;
    }
}
