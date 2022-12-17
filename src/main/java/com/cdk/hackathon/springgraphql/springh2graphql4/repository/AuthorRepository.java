package com.cdk.hackathon.springgraphql.springh2graphql4.repository;

import com.cdk.hackathon.springgraphql.springh2graphql4.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Optional<Author> findByFirstNameAndLastName(String firstName, String lastName);
}
