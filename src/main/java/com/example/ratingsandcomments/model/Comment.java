package com.example.ratingsandcomments.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Comment")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Comment {

    @Id
    @GeneratedValue
    @Column(name= "commentID")
    private Long commentID;

    @ManyToOne
    @JoinColumn(name = "userID")
    private String user;

    @ManyToOne
    @JoinColumn(name= "book")
    private String book;

    @Column(name = "comment")
    private String comment;


}
