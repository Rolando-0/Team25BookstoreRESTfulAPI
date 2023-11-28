package com.example.ratingsandcomments.service;


import com.example.ratingsandcomments.model.Comment;
import com.example.ratingsandcomments.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository CommentRepository;

    public Comment createComment(Comment comment){
        return CommentRepository.save(comment);
    }

    /* public List<String> getComments(Integer bookID){
        return CommentRepository.findByBookID;
    }
 */
}
