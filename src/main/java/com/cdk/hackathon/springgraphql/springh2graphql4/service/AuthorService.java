package com.cdk.hackathon.springgraphql.springh2graphql4.service;

import com.cdk.hackathon.springgraphql.springh2graphql4.model.Author;
import com.cdk.hackathon.springgraphql.springh2graphql4.model.Book;

public interface AuthorService  {
    public void saveOrUpdateExistingBookAuthor(Book existingBook, Book bookInput);
    public Author getExistingAuthor(Book bookInput);
}
