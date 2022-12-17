package com.cdk.hackathon.springgraphql.springh2graphql4.service;

import com.cdk.hackathon.springgraphql.springh2graphql4.model.Author;
import com.cdk.hackathon.springgraphql.springh2graphql4.model.Book;
import com.cdk.hackathon.springgraphql.springh2graphql4.repository.AuthorRepository;
import org.hibernate.Hibernate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService{

    AuthorRepository authorRepo;

    public AuthorServiceImpl(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public void saveOrUpdateExistingBookAuthor(Book existingBook, Book bookInput) {
        Author existingAuthor = getExistingAuthor(bookInput);
        if(existingBook != null){
            if(existingAuthor != null)
                existingBook.setAuthor(existingAuthor);
            else
                existingBook.setAuthor(bookInput.getAuthor());
        }else{
            if(existingAuthor != null)
                bookInput.setAuthor(existingAuthor);
            else
                bookInput.setAuthor(bookInput.getAuthor());
        }
    }

    @Nullable
    public Author getExistingAuthor(@NotNull Book bookInput) {
        return authorRepo.findByFirstNameAndLastName(bookInput.getAuthor().getFirstName(), bookInput.getAuthor().getLastName())
                .orElse(null);
    }
}
