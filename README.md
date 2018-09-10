## graphql-demo
This is a spring-boot Java application for exploring GraphQL(https://graphql.org/) features.

The demo is a basic CRUD application, which simply holds two entities *Artist* and *Song* by the artist. 

# Usage
__Build__
```
mvn clean install
```
__Run__
From bash:
```
./run.sh
```

or
```
java -jar ./target/graphql-demo-0.0.1-SNAPSHOT.jar
```

__Query__
Open the following link in the browser:
```
http://localhost:8080/graphiql
```
TheGraphiQL UI provides an interactive UI for running the GraphQL queries and supports auto complete.

Some basic operations:
List all Artists and Songs by the artist
```
{
  allArtists {
    name
    country
    artistId
    songs {
      duration
      genre
      title
    }
  }
}
```

Create a new artist:
```
mutation {
  createArtist(country: "US", name: "Madonna") {
    name
    country
    artistId
  }
}
```

Create a song:
```
mutation {
  createSong(artist: "Madonna", duration: 5, genre: "Pop", title: "Material Girl") {
    duration
    genre
    title
    songId
  }
}

__Shutdown__
```
curl -X POST localhost:8080/actuator/shutdown
```