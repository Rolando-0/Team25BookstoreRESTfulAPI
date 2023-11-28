package com.example.ratingsandcomments.model;

import com.example.ratingsandcomments.model.Book;
import com.example.ratingsandcomments.model.User;

import javax.persistence.*;

import lombok.*;

import java.text.SimpleDateFormat;

@Entity
@Table(name = "Rating")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ratingID")
    private Long ratingID;

    @ManyToOne
    @JoinColumn(name = "user")
    private String user;

    @ManyToOne
    @JoinColumn(name= "bookID")
    private String book;

    @Column(name = "Rating")
    private Integer rating;


}
