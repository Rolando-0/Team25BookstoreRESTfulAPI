package com.example.ratingsandcomments.repository;

import com.example.ratingsandcomments.model.Book;
import com.example.ratingsandcomments.model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating, Long> {
    List<Rating> findByBook (Book book);

}
