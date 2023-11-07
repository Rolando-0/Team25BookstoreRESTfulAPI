package com.example.Team25SpringMongoRest.service;

import com.example.Team25SpringMongoRest.model.BookDetails.Book;

import java.util.List;

public interface ShoppingCartService {

    double getSubtotal(String userId);

    String addToCart(String bookId, String userId);

    List<Book> getCartItems(String userId);

    String removeFromCart(String bookId, String userId);
}