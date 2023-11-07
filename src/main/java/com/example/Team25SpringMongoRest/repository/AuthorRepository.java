package com.example.Team25SpringMongoRest.repository;



import com.example.Team25SpringMongoRest.model.BookDetails.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
