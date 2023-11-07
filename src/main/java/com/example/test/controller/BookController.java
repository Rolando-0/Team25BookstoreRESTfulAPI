package com.example.test.controller;

import com.example.test.model.Book;
import com.example.test.repository.BookRepository;
import com.example.test.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book); // Assuming addBook method in BookService
    }

    @GetMapping
    public List<Book> getBooksByGenre(@RequestParam("genre") String genre) {
        return bookService.getBooksByGenre(genre); // Assuming getBooksByGenre method in BookService
    }
    @GetMapping("/top-sellers")
    public ResponseEntity<List<Book>> getTopSellers() {
        List<Book> topSellers = bookService.getTopSellers();
        return ResponseEntity.ok(topSellers);
    }
    @GetMapping("/by-rating")
    public ResponseEntity<List<Book>> getBooksByRating(
            @RequestParam("rating") double rating
    ) {
        List<Book> books = bookService.findBooksByRating(rating);
        return ResponseEntity.ok(books);
    }
    @PutMapping("/discount")
    public ResponseEntity<List<Book>> discountBooksByPublisher(
            @RequestParam("publisher") String publisher,
            @RequestParam("discountPercent") double discountPercent
    ) {
        List<Book> discountedBooks = bookService.discountBooksByPublisher(publisher, discountPercent);
        return ResponseEntity.ok(discountedBooks);
    }
}




