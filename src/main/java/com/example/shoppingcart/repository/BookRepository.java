package com.example.shoppingcart.repository;

import com.example.shoppingcart.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {
    Optional<Book> findById(String bookId);
}