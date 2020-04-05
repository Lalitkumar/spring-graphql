package com.lalit.graphql.springbootgrapqlexample.service;

import com.lalit.graphql.springbootgrapqlexample.model.User;
import com.lalit.graphql.springbootgrapqlexample.repository.UserRepository;
import com.lalit.graphql.springbootgrapqlexample.service.datafetcher.AllUsersDataFetcher;
import com.lalit.graphql.springbootgrapqlexample.service.datafetcher.UserDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

@Service
public class GraphQLService {

    private GraphQL graphQL;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AllUsersDataFetcher allUsersDataFetcher;

    @Autowired
    UserDataFetcher userDataFetcher;

    @Value("classpath:users.graphql")
    Resource resource;

    @PostConstruct
    public void loadSchema()throws IOException{

        loadDataIntHSQL();

        File schemaFile = resource.getFile();

        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring(){
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                            .dataFetcher("allUsers", allUsersDataFetcher)
                            .dataFetcher("user", userDataFetcher))
                .build();
    }

    private void loadDataIntHSQL(){
        Stream.of(
                new User("1", "Lalit", "Thakare", "19 Sep 89"),
                new User("2", "Pooja", "Thakare", "18 April 93"),
                new User("3", "Anaaya", "Thakare", "12 Aug 17")
        ).forEach(user -> {
            userRepository.save(user);
        });
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }
}
