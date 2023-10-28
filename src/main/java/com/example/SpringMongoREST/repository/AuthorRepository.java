package com.example.SpringMongoREST.repository;

import com.example.SpringMongoREST.Author.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
