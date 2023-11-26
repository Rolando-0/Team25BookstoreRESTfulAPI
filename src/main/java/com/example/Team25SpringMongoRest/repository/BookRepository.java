package com.example.test.repository;

import com.example.test.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByGenre(String genre);
    List<Book> findTop10ByOrderByCopiesSoldDesc();
    List<Book> findByRating(double rating);
    List<Book> findByPublisher(String publisher);
}

