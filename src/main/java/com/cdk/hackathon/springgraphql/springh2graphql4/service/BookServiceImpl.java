package com.cdk.hackathon.springgraphql.springh2graphql4.service;

import com.cdk.hackathon.springgraphql.springh2graphql4.model.Author;
import com.cdk.hackathon.springgraphql.springh2graphql4.model.Book;
import com.cdk.hackathon.springgraphql.springh2graphql4.repository.AuthorRepository;
import com.cdk.hackathon.springgraphql.springh2graphql4.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements BookService {
    private BookRepository bookRepo;
    private AuthorRepository authorRepo;

    private AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepo, AuthorRepository authorRepo, AuthorService authorService) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.authorService = authorService;
    }

    @Override
    public Book getBookById(long id) {
        return bookRepo.findById(id).get();
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<Book>();
        bookRepo.findAll().iterator().forEachRemaining(book -> books.add(book));
        return books;
    }

    @Override
    @Transactional
    public Book saveBook(Book bookInput) {
        Book existingBook = bookRepo.findFirstByIsbn(bookInput.getIsbn()).orElse(null);
        authorService.saveOrUpdateExistingBookAuthor(existingBook, bookInput);
        if (existingBook == null) {
            return bookRepo.save(bookInput);
        }
        existingBook.setName(bookInput.getName());
        existingBook.setIsbn(bookInput.getIsbn());
        existingBook.setPageCount(bookInput.getPageCount());
        return bookRepo.save(existingBook);

    }

    @Override
    @Transactional
    public void deleteBookById(Long id) {
        bookRepo.deleteById(id);
    }
}
