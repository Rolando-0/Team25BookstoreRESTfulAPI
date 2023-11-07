package com.example.Team25SpringMongoRest.repository;

import com.example.Team25SpringMongoRest.model.BookDetails.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {
    Optional<Book> findById(String bookId);




}