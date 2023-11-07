package com.example.Team25SpringMongoRest.service;
import com.example.Team25SpringMongoRest.model.BookDetails.Book;
import com.example.Team25SpringMongoRest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public Optional<Book> findByIsbn(String isbn) {
        return bookRepository.findById(isbn);
    }

 }
}
