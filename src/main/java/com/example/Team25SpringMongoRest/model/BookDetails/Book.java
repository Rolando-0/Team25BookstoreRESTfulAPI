package com.example.Team25SpringMongoRest.model.BookDetails;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Book {
    @Id
    private String id;

    private String isbn;
    private String name;
    private String description;
    private Double price;
    private String authorId;
    private String genre;
    private String publisher;
    private int yearPublished;
    private int copiesSold;


}