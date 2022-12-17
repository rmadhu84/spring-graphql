package com.cdk.hackathon.springgraphql.springh2graphql4.controller;

import com.cdk.hackathon.springgraphql.springh2graphql4.model.Author;
import com.cdk.hackathon.springgraphql.springh2graphql4.model.Book;
import com.cdk.hackathon.springgraphql.springh2graphql4.service.BookService;
import graphql.Internal;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.type.IntegerType;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BookMutation implements   {

    private BookService bookService;

    public BookMutation(BookService bookService) {
        this.bookService = bookService;
    }

    public Book addBook(String name, String isbn, String pageCount, Author author){
        Book book = new Book(name, isbn, Integer.parseInt(pageCount), author);
        bookService.saveBook(book);
        return book;
    }

    public Book createOrUpdate(Book book){
      return bookService.saveBook(book);
    }

    public String deleteBook(Long id){
        bookService.deleteBookById(id);
        return "Book deleted";
    }

}
