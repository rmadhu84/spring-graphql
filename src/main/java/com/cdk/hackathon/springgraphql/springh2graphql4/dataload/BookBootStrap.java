package com.cdk.hackathon.springgraphql.springh2graphql4.dataload;

import com.cdk.hackathon.springgraphql.springh2graphql4.model.Author;
import com.cdk.hackathon.springgraphql.springh2graphql4.model.Book;
import com.cdk.hackathon.springgraphql.springh2graphql4.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
@Transactional
public class BookBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private BookRepository bookRepo;

    public BookBootStrap(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    private List<Book> loadData() {
        return Arrays.asList(new Book("Harry Potter and the Philosopher's Stone", "ISBN-1", 223, new Author("Joanne", "Rowling")),
                new Book("Moby Dick", "ISBN-2", 635, new Author("Herman", "Melville")),
                new Book("Interview with the vampire", "ISBN-3", 371, new Author("Anne", "Rice")));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Book load - started");
        bookRepo.saveAll(this.loadData());
        log.info("Book load - completed");
    }
}
