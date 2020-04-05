package com.lalit.graphql.springbootgrapqlexample.service.datafetcher;

import com.lalit.graphql.springbootgrapqlexample.model.User;
import com.lalit.graphql.springbootgrapqlexample.repository.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllUsersDataFetcher implements DataFetcher<List<User>> {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return userRepository.findAll();
    }
}
