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
        return bookRepository.save(book);
    }
    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }
    public List<Book> findBooksByRating(double rating) {
        return bookRepository.findByRating(rating);
    }
    public List<Book> getTopSellers() {
        return bookRepository.findTop10ByOrderByCopiesSoldDesc();
    }
    public List<Book> getBooksByPublisher(String publisher) {
        return bookRepository.findByPublisher(publisher);
    }
    public void updatePricesByPublisher(String publisher, double discountPercent) {
        List<Book> books = bookRepository.findByPublisher(publisher);
        for (Book book : books) {
            double discountedPrice = book.getPrice() * (1 - discountPercent / 100);
            book.setPrice(discountedPrice);
            bookRepository.save(book);
        }
    }
}







