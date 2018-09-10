package io.graphql.demo.query;

import org.springframework.stereotype.Component;

import io.graphql.demo.entity.Artist;

@Component
public class UnannotatedQuery {

    /**
     * Invoke with {getGreeting(arg0: {name:"John", country:"US"})}
     * @param artist
     * @return greeting string
     */
    public String getGreeting(final Artist artist) {
        return "Hello " + artist.getName() + "!";
    }
}
