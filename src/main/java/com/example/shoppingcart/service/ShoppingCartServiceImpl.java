package com.example.shoppingcart.service;

import com.example.shoppingcart.model.Book;
import com.example.shoppingcart.model.ShoppingCart;
import com.example.shoppingcart.repository.ShoppingCartRepository;
import com.example.shoppingcart.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public double getSubtotal(String userId) {
        ShoppingCart cart = shoppingCartRepository.findByUserId(userId);
        if (cart == null) {
            throw new RuntimeException("Shopping cart not found for user: " + userId);
        }
        return cart.getBooks().stream().mapToDouble(Book::getPrice).sum();
    }

    @Override
    public String addToCart(String userId, String bookId) {
        ShoppingCart cart = shoppingCartRepository.findByUserId(userId);
        if (cart == null) {
            throw new RuntimeException("Shopping cart not found for user: " + userId);
        }

        try {
            Book bookToAdd = bookRepository.findById(bookId)
                    .orElseThrow(() -> new NoSuchElementException("Book not found with ID: " + bookId));

            // Check if the book is already in the cart
            if (!cart.getBooks().contains(bookToAdd)) {
                cart.getBooks().add(bookToAdd);
                shoppingCartRepository.save(cart);
                return "Book added to the shopping cart successfully";
            } else {
                return "Book is already in the shopping cart. Quantity increased.";
            }
        } catch (NoSuchElementException e) {
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public List<Book> getCartItems(String userId) {
        ShoppingCart cart = shoppingCartRepository.findByUserId(userId);
        if (cart == null) {
            throw new RuntimeException("Shopping cart not found for user: " + userId);
        }
        return cart.getBooks();
    }

    @Override
    public String removeFromCart(String userId, String bookId) {
        ShoppingCart cart = shoppingCartRepository.findByUserId(userId);
        if (cart == null) {
            throw new RuntimeException("Shopping cart not found for user: " + userId);
        }

        try {
            Book bookToRemove = bookRepository.findById(bookId)
                    .orElseThrow(() -> new NoSuchElementException("Book not found with ID: " + bookId));

            // Remove the book from the cart
            boolean removed = cart.getBooks().remove(bookToRemove);
            if (removed) {
                shoppingCartRepository.save(cart);
                return "Book removed from the shopping cart successfully";
            } else {
                return "Book not found in the shopping cart";
            }
        } catch (NoSuchElementException e) {
            return "Error: " + e.getMessage();
        }
    }
}
