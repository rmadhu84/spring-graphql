package com.cdk.hackathon.springgraphql.springh2graphql4.repository;

import com.cdk.hackathon.springgraphql.springh2graphql4.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book,Long> {
    Optional<Book> findFirstByIsbn(String isbn);
}
