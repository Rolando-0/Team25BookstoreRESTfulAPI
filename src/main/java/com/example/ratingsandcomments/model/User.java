package com.example.ratingsandcomments.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter
@Setter
@Document
@NoArgsConstructor
@AllArgsConstructor

@Data
public class User {
    @Id
    private Long id;
    private String username;
}
