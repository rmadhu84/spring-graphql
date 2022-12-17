package com.cdk.hackathon.springgraphql.springh2graphql4.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static void copyProperties(Author source, Author target){
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
    }

    public Boolean isEmpty(){
        if(this.id == 0l && this.firstName == null && this.lastName == null)
            return true;
        else
            return false;
    }
}
