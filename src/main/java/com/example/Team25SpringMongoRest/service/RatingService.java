package com.example.ratingsandcomments.service;

import com.example.ratingsandcomments.model.Book;
import com.example.ratingsandcomments.model.Rating;
import com.example.ratingsandcomments.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private RatingRepository RatingRepository;

    public Rating createRating(Rating rating){
        return RatingRepository.save(rating);

    }

    public List<Rating> getRating(Book book){
        return RatingRepository.findByBook(book);

    }






}






