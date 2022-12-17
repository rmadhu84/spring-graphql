package com.cdk.hackathon.springgraphql.springh2graphql4.service;

import com.cdk.hackathon.springgraphql.springh2graphql4.model.Book;

import java.util.List;

public interface BookService {
    public Book getBookById(long id);

    public List<Book> getAllBooks();

    public Book saveBook(Book book);

    public void deleteBookById(Long id);
}
