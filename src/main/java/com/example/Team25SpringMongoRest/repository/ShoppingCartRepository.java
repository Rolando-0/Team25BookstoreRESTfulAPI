package com.example.Team25SpringMongoRest.repository;

import com.example.Team25SpringMongoRest.model.ShoppingCart.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

    ShoppingCart findByUserId(String userId);
}