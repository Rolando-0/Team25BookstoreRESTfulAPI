package com.example.Team25SpringMongoRest.controller;

import com.example.Team25SpringMongoRest.model.BookDetails.Author;
import com.example.Team25SpringMongoRest.model.BookDetails.Book;
import com.example.Team25SpringMongoRest.service.AuthorService;
import com.example.Team25SpringMongoRest.service.BookService;
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

    /**         TO BE IMPLEMENTED
    @GetMapping("/{authorId}/books")
    public List<Book> getBooksByAuthor(@PathVariable String authorId) {
        return bookService.findBooksByAuthorId(authorId);
    }
    */
}

