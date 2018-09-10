package io.graphql.demo.controller;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.graphql.demo.query.ArtistQuery;
import io.graphql.demo.query.SongQuery;
import io.graphql.demo.query.UnannotatedQuery;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.query.PublicResolverBuilder;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GraphQueryController {

    private GraphQL graphQL;

    @Autowired
    private ArtistQuery artistQuery;

    @Autowired
    private SongQuery songQuery;

    @Autowired
    private UnannotatedQuery unannotatedQuery;

    @PostConstruct
    public void init() {
        GraphQLSchema schema = new GraphQLSchemaGenerator()
            .withResolverBuilders(new AnnotatedResolverBuilder(), new PublicResolverBuilder("io.graphql.demo.query.entity"))
            .withOperationsFromSingleton(artistQuery).withOperationsFromSingleton(songQuery).withOperationsFromSingleton(unannotatedQuery)
            .withValueMapperFactory(new JacksonValueMapperFactory()).withBasePackage("io.graphql.demo.query.entity").generate();
        graphQL = GraphQL.newGraphQL(schema).build();
        log.info("| Generated GraphQL Schema");
    }

    @PostMapping(value = "/graphql", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String, Object> indexFromAnnotated(@RequestBody Map<String, String> request, HttpServletRequest raw) {
        ExecutionResult executionResult = graphQL.execute(ExecutionInput.newExecutionInput().query(request.get("query"))
            .operationName(request.get("operationName")).context(raw).build());
        return executionResult.toSpecification();
    }

}
