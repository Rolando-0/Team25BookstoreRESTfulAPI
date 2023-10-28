package com.example.SpringMongoREST.repository;

import com.example.SpringMongoREST.Book.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    Optional<Book> findByIsbn(String isbn);
    List<Book> findByAuthorId(String authorId); // Define the method for finding books by authorId
}
