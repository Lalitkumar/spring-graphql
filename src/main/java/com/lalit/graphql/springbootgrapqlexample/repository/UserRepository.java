package com.lalit.graphql.springbootgrapqlexample.repository;

import com.lalit.graphql.springbootgrapqlexample.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public List<User> findAll() {
        return getUsers();
    }

    private List<User> getUsers() {
        List<User> list = new ArrayList<>(3);
        list.add(new User("1", "Lalit", "Thakare", "19 Sep"));
        list.add(new User("1", "Pooja", "Thakare", "18 Apr"));
        list.add(new User("1", "Anaaya", "Thakare", "13 Aug"));

        return list;
    }
}

