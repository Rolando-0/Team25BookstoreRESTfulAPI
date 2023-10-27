package com.example.Team25SpringMongoRest.repository;

import com.example.Team25SpringMongoRest.model.ShoppingCart.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {
    Optional<Book> findById(String bookId);
}