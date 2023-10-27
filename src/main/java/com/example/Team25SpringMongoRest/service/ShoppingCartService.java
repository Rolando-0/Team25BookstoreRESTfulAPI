package com.example.Team25SpringMongoRest.service;

import com.example.Team25SpringMongoRest.model.ShoppingCart.Book;
import com.example.Team25SpringMongoRest.model.ShoppingCart.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    double getSubtotal(String userId);

    String addToCart(String bookId, String userId);

    List<Book> getCartItems(String userId);

    String removeFromCart(String bookId, String userId);
}