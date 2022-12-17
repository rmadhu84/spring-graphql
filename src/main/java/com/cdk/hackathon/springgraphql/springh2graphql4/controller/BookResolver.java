package com.cdk.hackathon.springgraphql.springh2graphql4.controller;

import com.cdk.hackathon.springgraphql.springh2graphql4.model.Book;
import com.cdk.hackathon.springgraphql.springh2graphql4.service.BookService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookResolver implements GraphQLQueryResolver {
    private BookService bookService;

    public BookResolver(BookService bookService) {
        this.bookService = bookService;
    }

    public Book bookById(Long id) {
        return bookService.getBookById(id);
    }

    public List<Book> allBooks(){
        return bookService.getAllBooks();
    }
}
