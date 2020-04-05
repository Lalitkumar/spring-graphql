package com.lalit.graphql.springbootgrapqlexample.controller;


import com.lalit.graphql.springbootgrapqlexample.service.GraphQLService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    GraphQLService graphQLService;

    @PostMapping
    public ResponseEntity getUsers(@RequestBody String query) {
        ExecutionResult result = graphQLService.getGraphQL().execute(query);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }
}
