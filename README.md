# graphql-demo
This is a basic CRUD application build using spring-boot and Java for learning basic GraphQL(https://graphql.org/) features. The application holds two in-memory entities *Artist* and *Song* and exposes the entities through basic GraphQL queries. The user can list all the artists and the songs created by the artist. Other supported functions include creating new artist and songs through queries. Example usage is given below:

## Usage

__Build__
```bash
mvn clean install
```
__Run__

```bash
./run.sh
```

or
```bash
java -jar ./target/graphql-demo-0.0.1-SNAPSHOT.jar
```

__Query__
Open the following link in the browser:

```
http://localhost:8080/graphiql
```
TheGraphiQL UI provides an interactive UI for running the GraphQL queries and supports auto complete.

__Shutdown__
```bash
curl -X POST localhost:8080/actuator/shutdown
```

## Some basic operations:

### List all Artists and Songs by the artist
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

### Create a new artist:
```
mutation {
  createArtist(country: "US", name: "Madonna") {
    name
    country
    artistId
  }
}
```

### Create a song:
```
mutation {
  createSong(artist: "Madonna", duration: 5, genre: "Pop", title: "Material Girl") {
    duration
    genre
    title
    songId
  }
}
```
