package com.example.ratingsandcomments.repository;

import com.example.ratingsandcomments.model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends MongoRepository<Rating, Long> {

}
