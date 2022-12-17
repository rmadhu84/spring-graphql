package com.cdk.hackathon.springgraphql.springh2graphql4.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(unique = true)
    private String isbn;

    private Integer pageCount;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(String name, String isbn, Integer pageCount) {
        this.name = name;
        this.isbn = isbn;
        this.pageCount = pageCount;
    }

    public Book(String name, String isbn, Integer pageCount, Author author) {
        this.name = name;
        this.isbn = isbn;
        this.pageCount = pageCount;
        this.author = author;
    }

    public static void copyProperties(Book source, Book target){
        target.setName(source.getName());
        target.setIsbn(source.getIsbn());
        target.setPageCount(source.getPageCount());
    }

    public Boolean isEmpty(){
        if(this.id ==0l && this.name == null && this.isbn == null && this.pageCount == null && this.author == null)
            return true;
        else
            return false;
    }
}
