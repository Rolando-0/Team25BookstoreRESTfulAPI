package com.example.ratingsandcomments.controller;

import com.example.ratingsandcomments.model.Rating;
import com.example.ratingsandcomments.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {


    @Autowired
    private RatingService ratingService;

    @RequestMapping(method= RequestMethod.POST, value ="/rating")
    public ResponseEntity<String> createRating(@RequestBody Rating rating){
        if (rating.getRating() < 1 || rating.getRating() > 5){
            return new ResponseEntity<>("Insert a rating 1-5", HttpStatus.BAD_REQUEST);
        }

        ratingService.createRating(rating);
        return new ResponseEntity<>("Rating submitted", HttpStatus.OK);

    }


}

