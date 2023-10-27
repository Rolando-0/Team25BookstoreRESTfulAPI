package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.Book;
import com.example.shoppingcart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/subtotal")
    public ResponseEntity<Double> getSubtotal(@RequestParam String userId) {
        // If need to add $ change from double to a string
        double subtotal = shoppingCartService.getSubtotal(userId);
        return ResponseEntity.ok(subtotal);
    }

    @PostMapping("/add-to-cart")
    public ResponseEntity<String> addToCart(@RequestParam String userId, @RequestParam String bookId) {
        String resultMessage = shoppingCartService.addToCart(userId, bookId);
        return ResponseEntity.ok(resultMessage);
    }

    @GetMapping("/get-cart-items")
    public ResponseEntity<List<Book>> getCartItems(@RequestParam String userId) {
        List<Book> cartItems = shoppingCartService.getCartItems(userId);
        return ResponseEntity.ok(cartItems);
    }

    @DeleteMapping("/remove-from-cart")
    public ResponseEntity<String> removeFromCart(@RequestParam String userId, @RequestParam String bookId) {
        String resultMessage = shoppingCartService.removeFromCart(userId, bookId);
        return ResponseEntity.ok(resultMessage);
    }
}
