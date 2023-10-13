package com.example.shoppingcart.repository;

import com.example.shoppingcart.model.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

    ShoppingCart findByUserId(String userId);
}
