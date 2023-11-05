package com.example.shoppingcart.service;

import com.example.shoppingcart.model.Book;
import com.example.shoppingcart.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    Double getSubtotal(String userId);

    String addToCart(String userId, String bookId);

    List<Book> getCartItems(String userId);

    String removeFromCart(String userId, String bookId);
}
