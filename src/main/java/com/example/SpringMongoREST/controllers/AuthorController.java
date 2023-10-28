package com.example.SpringMongoREST.controllers;

import com.example.SpringMongoREST.Author.Author;
import com.example.SpringMongoREST.Book.Book;
import com.example.SpringMongoREST.services.AuthorService;
import com.example.SpringMongoREST.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @PostMapping
    public void addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
    }

    @GetMapping("/{authorId}/books")
    public List<Book> getBooksByAuthor(@PathVariable String authorId) {
        return bookService.findBooksByAuthorId(authorId);
    }
}
