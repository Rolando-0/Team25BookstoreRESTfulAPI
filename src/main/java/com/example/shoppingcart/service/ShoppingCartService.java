package com.example.shoppingcart.service;

import com.example.shoppingcart.model.Book;
import com.example.shoppingcart.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    double getSubtotal(String userId);

    String addToCart(String bookId, String userId);

    List<Book> getCartItems(String userId);

    String removeFromCart(String bookId, String userId);
}
