package com.example.test.service;

import com.example.test.model.Book;
import com.example.test.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        // Implement logic to add a book to the repository
        return bookRepository.save(book);
    }

    public List<Book> getBooksByGenre(String genre) {
        // Implement logic to retrieve books by genre from the repository
        return bookRepository.findByGenre(genre);
    }
    public List<Book> findBooksByRating(double rating) {
        // Implement logic to retrieve books with a rating greater than or equal to the specified rating
        return bookRepository.findByRatingGreaterThanEqual(rating);
    }
    public List<Book> getTopSellers() {
        return bookRepository.findTop10ByOrderByCopiesSoldDesc();
    }
    public List<Book> discountBooksByPublisher(String publisher, double discountPercent) {
        List<Book> books = bookRepository.findByPublisher(publisher);

        for (Book book : books) {
            double discountedPrice = book.getPrice() * (1 - discountPercent / 100);
            book.setPrice(discountedPrice);
        }

        bookRepository.saveAll(books); // Save the updated books to the database

        return books;
    }
}





