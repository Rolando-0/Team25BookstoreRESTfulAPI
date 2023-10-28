package com.example.SpringMongoREST.services;

import com.example.SpringMongoREST.Book.Book;
import com.example.SpringMongoREST.repository.BookRepository;
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

    public List<Book> findBooksByAuthorId(String authorId) {
        return bookRepository.findByAuthorId(authorId);
    }
}
