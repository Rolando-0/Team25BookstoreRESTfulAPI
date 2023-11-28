package com.example.ratingsandcomments.controller;

import com.example.ratingsandcomments.model.Comment;
import com.example.ratingsandcomments.model.Rating;
import com.example.ratingsandcomments.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(method= RequestMethod.POST, value ="/comment")
    public ResponseEntity<String> createRating(@RequestBody Comment comment){
        commentService.createComment(comment);
        return new ResponseEntity<>("Comment submitted", HttpStatus.OK);
    }

    //@RequestMapping(method= RequestMethod.GET, value = "/comment")


}
