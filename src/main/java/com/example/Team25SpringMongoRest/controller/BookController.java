package com.example.test.controller;

import com.example.test.model.Book;
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
        return bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getBooksByGenre(@RequestParam("genre") String genre) {
        return bookService.getBooksByGenre(genre);
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
    @PatchMapping("/updatePrice/{publisher}")
    public void updatePricesByPublisher(
            @PathVariable String publisher,
            @RequestParam double discountPercent
    ) {
        bookService.updatePricesByPublisher(publisher, discountPercent);
    }
}
