package com.lalit.graphql.springbootgrapqlexample.repository;

import com.lalit.graphql.springbootgrapqlexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
