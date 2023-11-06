package com.example.ratingsandcomments.model;

import lombok.*;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document

public class Book {
    @Id
    private Long id;
    private String title;
    private String isbn;


}
