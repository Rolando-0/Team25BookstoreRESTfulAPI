package com.example.Team25SpringMongoRest.controller;

import com.example.Team25SpringMongoRest.model.BookDetails.Book;
import com.example.Team25SpringMongoRest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping("/{isbn}")
    public Optional<Book> getBookByIsbn(@PathVariable String isbn) {
        return bookService.findByIsbn(isbn);
    }

}