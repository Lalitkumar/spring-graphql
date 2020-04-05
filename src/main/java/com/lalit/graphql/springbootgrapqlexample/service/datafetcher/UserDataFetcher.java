package com.lalit.graphql.springbootgrapqlexample.service.datafetcher;

import com.lalit.graphql.springbootgrapqlexample.model.User;
import com.lalit.graphql.springbootgrapqlexample.repository.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDataFetcher implements DataFetcher<User> {

    @Autowired
    UserRepository userRepository;

    @Override
    public User get(DataFetchingEnvironment dataFetchingEnvironment) {
        String id =  dataFetchingEnvironment.getArgument("id");
        return userRepository.getOne(id);
    }
}
